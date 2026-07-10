package com.test.employees.Repository;

import com.test.employees.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    boolean existsByEmail(String email);

    Optional<Employee> findByIdAndStatus(Long id, String status);

    List<Employee> findByStatus(String status);

    Page<Employee> findByStatus(String status, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.dept = :dept")
    List<Employee> findByDepartment(@Param("dept") String dept);
}
