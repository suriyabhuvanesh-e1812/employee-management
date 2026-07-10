package com.test.employees.Dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


@JsonPropertyOrder({"id", "name", "email", "dept", "salary", "status"})
@Data
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String dept;
    private double salary;
    private String status;

}
