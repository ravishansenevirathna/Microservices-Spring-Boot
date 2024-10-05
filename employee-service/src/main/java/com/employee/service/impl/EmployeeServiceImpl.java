package com.employee.service.impl;

import com.employee.dto.DepartmentDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.responseDto.ApiResponseDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.ApiFeignClient;
import com.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepo employeeRepo;
    //using rest template
//    private RestTemplate restTemplate;

//    using webclient
//    private WebClient webClient;

//    using feignClient
     private ApiFeignClient apiFeignClient;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail(), employeeDto.getDepartmentCode());
        employeeRepo.save(employee);
        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());
        return employeeDto1;
    }


//using rest template
//    @Override
//    public ApiResponseDto getEmployeeById(Long id) {
//
//        Employee employee = employeeRepo.findById(id).get();
//
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/department/findByCode?departmentCode=" + employee.getDepartmentCode(), DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();
//
//        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());
//
//        ApiResponseDto apiResponseDto = new ApiResponseDto();
//        apiResponseDto.setEmployeeDto(employeeDto1);
//        apiResponseDto.setDepartmentDto(departmentDto);
//
//        return apiResponseDto;
//
//    }


    //    using webclient
//    @Override
//    public ApiResponseDto getEmployeeById(Long id) {
//
//        Employee employee = employeeRepo.findById(id).get();
//
//
//        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/department/findByCode?departmentCode="+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
////                .block = Synchronous communication
//                .block();
//
//
//        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());
//
//        ApiResponseDto apiResponseDto = new ApiResponseDto();
//        apiResponseDto.setEmployeeDto(employeeDto1);
//        apiResponseDto.setDepartmentDto(departmentDto);
//
//        return apiResponseDto;
//
//    }


//using feignClient
    @Override
    public ApiResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepo.findById(id).get();


        DepartmentDto departmentDto = apiFeignClient.getDepartmentByCode(employee.getDepartmentCode());


        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto1);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;

    }
}
