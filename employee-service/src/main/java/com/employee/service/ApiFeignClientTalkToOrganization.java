package com.employee.service;

import com.employee.dto.DepartmentDto;
import com.employee.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "organization-service")
public interface ApiFeignClientTalkToOrganization {

    @GetMapping(path = "organization/getOrganizationByCode", params = "code")
    OrganizationDto getOrganizationByCode(@RequestParam(value = "code") String code);

}
