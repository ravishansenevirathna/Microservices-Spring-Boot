package com.employee.service.impl;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(employeeDto.getId(),employeeDto.getEmail(), employeeDto.getFirstName(), employeeDto.getLastName());
        employeeRepo.save(employee);
        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getEmail(), employee.getFirstName(), employee.getLastName());
        return employeeDto1;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee employee = employeeRepo.findById(id).get();
        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getEmail(), employee.getFirstName(), employee.getLastName());
        return employeeDto1;

    }
}
