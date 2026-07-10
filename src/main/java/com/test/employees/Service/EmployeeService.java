package com.test.employees.Service;

import com.test.employees.Dto.EmployeeRequestDTO;
import com.test.employees.Dto.EmployeeResponseDTO;
import com.test.employees.Dto.EmployeeUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);

    Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO patchEmployee(Long id, EmployeeUpdateDTO employeeUpdateDTO);

    String deleteEmployee(Long id);

    List<EmployeeResponseDTO> searchByDept(String dept);

}
