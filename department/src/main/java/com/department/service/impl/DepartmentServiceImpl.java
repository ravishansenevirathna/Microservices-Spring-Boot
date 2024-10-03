package com.department.service.impl;

import com.department.dto.DepartmentDto;
import com.department.entity.Department;
import com.department.repository.DepartmentRepo;
import com.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto.getId(),departmentDto.getDepartmentName(),departmentDto.getDepartmentDescription(),departmentDto.getDepartmentCode());

        Department department1 = departmentRepo.save(department);
        DepartmentDto departmentDto1 = new DepartmentDto(department1.getId(),department1.getDepartmentName(),department1.getDepartmentDescription(),department1.getDepartmentCode());

        return departmentDto1;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department1 = departmentRepo.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto1 = new DepartmentDto(department1.getId(),department1.getDepartmentName(),department1.getDepartmentDescription(),department1.getDepartmentCode());

        return departmentDto1;
    }
}
