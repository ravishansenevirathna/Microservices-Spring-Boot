package com.department.controller;

import com.department.dto.DepartmentDto;
import com.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {

        DepartmentDto departmentDto1 =departmentService.saveDepartment(departmentDto);
//

        return new ResponseEntity<>(departmentDto1, HttpStatus.OK);
    }

    @GetMapping(path = "/findByCode" , params = "departmentCode")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@RequestParam(value = "departmentCode") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
