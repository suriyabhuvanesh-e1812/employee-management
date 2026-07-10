package com.test.employees.Controller;

import com.test.employees.Dto.EmployeeRequestDTO;
import com.test.employees.Dto.EmployeeResponseDTO;
import com.test.employees.Dto.EmployeeUpdateDTO;
import com.test.employees.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeResponseDTO addEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.createEmployee(employeeRequestDTO);
    }

    @GetMapping("/paginated")
    public Page<EmployeeResponseDTO> getAllEmployees(@RequestParam  int page, @RequestParam int size,
                                          @RequestParam String sortBy, @RequestParam String sortOrder) {
        Sort sort;
        if (sortOrder.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        }
        else {
            sort = Sort.by(sortBy).descending();
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeService.getAllEmployees(pageable);
    }

    @GetMapping("/getAll")
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/find")
    public List<EmployeeResponseDTO> getAllByDept(@RequestParam String dept) {
        return employeeService.searchByDept(dept);
    }

    @GetMapping("/get/{id}")
    public EmployeeResponseDTO getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id ,@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.updateEmployee(id, employeeRequestDTO);
    }

    @PatchMapping("/change/{id}")
    public EmployeeResponseDTO changeEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeUpdateDTO employeeDTO) {
        return employeeService.patchEmployee(id, employeeDTO);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}
