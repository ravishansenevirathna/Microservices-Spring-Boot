package com.employee.service;

import com.employee.dto.EmployeeDto;
import com.employee.dto.responseDto.ApiResponseDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
