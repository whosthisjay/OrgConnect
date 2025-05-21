package com.microservice.organization_service.service;

import com.microservice.organization_service.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);
}
