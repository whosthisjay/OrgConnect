package com.microservice.employee_service.services.impl;

import com.microservice.employee_service.dto.APIResponseDto;
import com.microservice.employee_service.dto.DepartmentDto;
import com.microservice.employee_service.dto.EmployeeDto;
import com.microservice.employee_service.dto.OrganizationDto;
import com.microservice.employee_service.model.Employee;
import com.microservice.employee_service.repository.EmployeeRepository;
import com.microservice.employee_service.services.DepartmentClient;
import com.microservice.employee_service.services.EmployeeService;
import com.microservice.employee_service.services.OrganizationClient;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
//    private final RestTemplate restTemplate;
//    private WebClient webClient;
    private DepartmentClient client;
    private OrganizationClient organizationClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee,EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not Found!"));
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);

//        REST TEMPLATE
//        ResponseEntity<DepartmentDto> departmentDto = restTemplate.getForEntity("http://localhost:8080/api/departments/"+ employee.getDepartmentCode(),DepartmentDto.class);
//        use .getBody();

//        WEB CLIENT
//       DepartmentDto departmentDto =
//               webClient.get()
//                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();


        DepartmentDto departmentDto = client.getDepartmentByCode(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationClient.getOrganizationByCode(employeeDto.getOrganizationCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto ;
    }
}
