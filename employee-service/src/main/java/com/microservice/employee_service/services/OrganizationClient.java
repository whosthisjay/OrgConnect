package com.microservice.employee_service.services;

import com.microservice.employee_service.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8083",value = "ORGANIZATION-SERVICE")
public interface OrganizationClient {

    @GetMapping("/api/organizations/{organizationCode}")
    OrganizationDto getOrganizationByCode(@PathVariable String organizationCode);
}
