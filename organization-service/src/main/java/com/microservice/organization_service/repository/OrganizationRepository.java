package com.microservice.organization_service.repository;

import com.microservice.organization_service.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String organizationCode);
}
