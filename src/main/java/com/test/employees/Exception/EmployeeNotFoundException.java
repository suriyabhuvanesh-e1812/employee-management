package com.test.employees.Exception;

public class EmployeeNotFoundException extends RuntimeException
{
	public EmployeeNotFoundException(String message) {
        super(message);
    }

}
