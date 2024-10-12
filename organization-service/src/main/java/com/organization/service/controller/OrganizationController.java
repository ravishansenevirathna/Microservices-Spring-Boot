package com.organization.service.controller;

import com.organization.service.dto.OrganizationDto;
import com.organization.service.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/saveOrganization")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto organizationDto1 =organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(organizationDto1, HttpStatus.OK);
    }

    @GetMapping(path = "/getOrganizationByCode" , params = "code")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@RequestParam(value = "code") String code) {
        OrganizationDto organizationDto1= organizationService.getOrganizationByCode(code);
        return new ResponseEntity<>(organizationDto1, HttpStatus.OK);
    }

}
