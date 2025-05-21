package com.microservice.organization_service.service.impl;

import com.microservice.organization_service.dto.OrganizationDto;
import com.microservice.organization_service.model.Organization;
import com.microservice.organization_service.repository.OrganizationRepository;
import com.microservice.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = modelMapper.map(organizationDto,Organization.class);
        Organization savedOrganization = organizationRepository.save(organization);
        return modelMapper.map(savedOrganization,OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return modelMapper.map(organization,OrganizationDto.class);
    }
}
