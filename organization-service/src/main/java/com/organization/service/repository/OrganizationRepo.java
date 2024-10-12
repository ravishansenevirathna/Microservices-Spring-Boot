package com.organization.service.repository;

import com.organization.service.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String code);
}
