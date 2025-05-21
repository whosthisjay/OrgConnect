package com.microservice.employee_service.services;

import com.microservice.employee_service.dto.APIResponseDto;
import com.microservice.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
