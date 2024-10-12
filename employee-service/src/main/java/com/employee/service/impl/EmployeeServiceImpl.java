package com.employee.service.impl;

import com.employee.dto.DepartmentDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.OrganizationDto;
import com.employee.dto.responseDto.ApiResponseDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;
import com.employee.service.ApiFeignClient;
import com.employee.service.ApiFeignClientTalkToOrganization;
import com.employee.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepo employeeRepo;
    //using rest template
//    private RestTemplate restTemplate;

//    using webclient
//    private WebClient webClient;

//    using feignClient
     private ApiFeignClient apiFeignClient;

     private ApiFeignClientTalkToOrganization apiFeignTalkToOrganization;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail(), employeeDto.getDepartmentCode(),employeeDto.getOrganizationCode());
        employeeRepo.save(employee);
        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode(),employee.getOrganizationCode());
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
//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponseDto getEmployeeById(Long id) {

        LOGGER.info("@@@@@@@@@@@@@@@@@@@@@@@@@   getEmployeeByIdEmployeeService $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        Employee employee = employeeRepo.findById(id).get();


        DepartmentDto departmentDto = apiFeignClient.getDepartmentByCode(employee.getDepartmentCode());
        OrganizationDto organizationDto = apiFeignTalkToOrganization.getOrganizationByCode(employee.getOrganizationCode());



        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode(),employee.getOrganizationCode());

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto1);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto;

    }


//default method to if the department service not available
    public ApiResponseDto getDefaultDepartment(Long id,Exception exception) {

        LOGGER.info("getDefaultDepartment");

        Employee employee = employeeRepo.findById(id).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("WD-24");
        departmentDto.setDepartmentName("DEVELOPMENT DEPT");
        departmentDto.setDepartmentDescription("DEVELOPMENT team for outstanding processes");

        EmployeeDto employeeDto1 = new EmployeeDto(employee.getId(), employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode(),employee.getOrganizationCode());

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto1);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;

    }
}
