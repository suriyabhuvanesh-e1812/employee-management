package com.test.employees.Service.Implement;

import com.test.employees.Dto.EmployeeRequestDTO;
import com.test.employees.Dto.EmployeeResponseDTO;
import com.test.employees.Dto.EmployeeUpdateDTO;
import com.test.employees.Entity.Employee;
import com.test.employees.Exception.EmployeeExistException;
import com.test.employees.Exception.EmployeeNotFoundException;
import com.test.employees.Repository.EmployeeRepository;
import com.test.employees.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        if (employeeRepository.existsByEmail(employeeRequestDTO.getEmail())) {
            throw new EmployeeExistException("Employee Already Exists");
        }
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setDept(employeeRequestDTO.getDept());
        employee.setSalary(employeeRequestDTO.getSalary());
        employee.setStatus("Active");
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        Employee saved = employeeRepository.save(employee);
        log.info("Created Employee: {}", saved.getId());
        return convertDto(saved);
    }

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findByStatus("Active", pageable);
        return employees.map(this::convertDto);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findByStatus("Active");
        List<EmployeeResponseDTO> responseList = new ArrayList<>();
        for (Employee employee : employees) {
            responseList.add(convertDto(employee));
        }
        return responseList;
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findByIdAndStatus(id,"Active");
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        Employee emp = employee.get();
        return convertDto(emp);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO) {
        Optional<Employee> employee = employeeRepository.findByIdAndStatus(id,"Active");
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        Employee emp = employee.get();
        emp.setName(employeeRequestDTO.getName());
        emp.setEmail(employeeRequestDTO.getEmail());
        emp.setDept(employeeRequestDTO.getDept());
        emp.setSalary(employeeRequestDTO.getSalary());
        emp.setUpdatedAt(LocalDateTime.now());
        Employee updated = employeeRepository.save(emp);
        log.info("Updated Employee: {}", updated.getId());
        return convertDto(updated);
    }

    @Override
    public EmployeeResponseDTO patchEmployee(Long id, EmployeeUpdateDTO employeeDTO) {
        Optional<Employee> employee = employeeRepository.findByIdAndStatus(id,"Active");
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        Employee emp = employee.get();
        if (employeeDTO.getName() != null) {
            emp.setName(employeeDTO.getName());
        }
        if (employeeDTO.getEmail() != null) {
            emp.setEmail(employeeDTO.getEmail());
        }
        if (employeeDTO.getDept() != null) {
            emp.setDept(employeeDTO.getDept());
        }
        if (employeeDTO.getSalary()>0) {
            emp.setSalary(employeeDTO.getSalary());
        }
        emp.setUpdatedAt(LocalDateTime.now());
        Employee updated = employeeRepository.save(emp);
        log.info("Updated Employee : {}", updated.getId());
        return convertDto(updated);
    }

    @Override
    public String deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty() || employee.get().getStatus().equals("Inactive")) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        Employee emp = employee.get();
        emp.setStatus("Inactive");
        emp.setUpdatedAt(LocalDateTime.now());
        employeeRepository.save(emp);
        log.info("Deleted Employee : {}", id);
        return "Employee Deleted Successfully";
    }

    @Override
    public List<EmployeeResponseDTO> searchByDept(String dept) {
        List<Employee> emp = employeeRepository.findByDepartment(dept);
        if (emp.isEmpty()) {
            throw new EmployeeNotFoundException("Department Not Found");
        }
        List<EmployeeResponseDTO> responseList = new ArrayList<>();
        for (Employee employee : emp) {
            if (employee.getStatus().equals("Active")) {
                responseList.add(convertDto(employee));
            }
        }
        if (responseList.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return responseList;
    }

    private EmployeeResponseDTO convertDto(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setDept(employee.getDept());
        dto.setSalary(employee.getSalary());
        dto.setStatus(employee.getStatus());
        return dto;
    }
}
