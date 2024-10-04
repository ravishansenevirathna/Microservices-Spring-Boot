package com.employee.service;

import com.employee.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
