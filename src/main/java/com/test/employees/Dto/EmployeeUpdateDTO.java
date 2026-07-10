package com.test.employees.Dto;


import lombok.Data;

@Data
public class EmployeeUpdateDTO {

        private String name;
        private String email;
        private String dept;
        private double salary;

}
