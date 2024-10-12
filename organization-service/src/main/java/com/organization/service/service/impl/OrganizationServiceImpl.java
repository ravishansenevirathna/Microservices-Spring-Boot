package com.organization.service.service.impl;

import com.organization.service.dto.OrganizationDto;
import com.organization.service.entity.Organization;
import com.organization.service.mapper.OrganizationMapper;
import com.organization.service.repository.OrganizationRepo;
import com.organization.service.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;


    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization organization1 = organizationRepo.save(organization);
        return OrganizationMapper.mapToOrganizationDto(organization1);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        Organization organization = organizationRepo.findByOrganizationCode(code);
        return OrganizationMapper.mapToOrganizationDto(organization);

    }
}
