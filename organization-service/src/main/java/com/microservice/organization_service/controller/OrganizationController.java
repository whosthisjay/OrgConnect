package com.microservice.organization_service.controller;

import com.microservice.organization_service.dto.OrganizationDto;
import com.microservice.organization_service.service.impl.OrganizationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private final OrganizationServiceImpl organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> savedOrganization(@RequestBody OrganizationDto organizationDto){
        return new ResponseEntity<>(organizationService.saveOrganization(organizationDto), HttpStatus.CREATED);
    }

    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String organizationCode){
        return ResponseEntity.ok(organizationService.getOrganizationByCode(organizationCode));
    }
}
