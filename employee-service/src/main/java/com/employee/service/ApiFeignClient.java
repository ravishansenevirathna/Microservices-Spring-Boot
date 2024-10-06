package com.employee.service;

import com.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//for feignClient configure
//@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")

//for netflix in feignClient
@FeignClient(value = "department-service")
public interface ApiFeignClient {

//all the ways are correctly configured
    @GetMapping(path = "department/findByCode", params = "departmentCode")
    DepartmentDto getDepartmentByCode(@RequestParam(value = "departmentCode") String departmentCode);

//    @GetMapping(path = "department/findByCode")
//    DepartmentDto getDepartmentByCode(@RequestParam(value = "departmentCode") String departmentCode);

//this way
//    @GetMapping(path = "department/findByCode?departmentCode=")
//    DepartmentDto getDepartmentByCode(@RequestParam(value = "departmentCode") String departmentCode);


//or this way
//    @GetMapping(path = "department/findByCode", params = "departmentCode")
//    DepartmentDto getDepartmentByCode(@RequestParam(value = "departmentCode") String departmentCode);


}
