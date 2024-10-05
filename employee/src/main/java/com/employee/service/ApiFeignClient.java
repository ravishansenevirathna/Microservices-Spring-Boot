package com.employee.service;

import com.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")
public interface ApiFeignClient {


//this way
    @GetMapping(path = "department/findByCode?departmentCode=")
    DepartmentDto getDepartmentByCode(@RequestParam(value = "departmentCode") String departmentCode);


//or this way
//    @GetMapping(path = "department/findByCode", params = "departmentCode")
//    DepartmentDto getDepartmentByCode(@RequestParam(value = "departmentCode") String departmentCode);


}
