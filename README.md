# OrgConnect – Microservice-based Organizational Management Syste
OrgConnect is a microservices-based Java Spring Boot project that manages employees, departments, and organizations efficiently. It uses Spring Cloud components like Eureka, API Gateway, and Config Server to demonstrate scalable, maintainable architecture.

## 🧩 Microservices Overview

### 1. **Employee Service**
Manages employee information such as name, email, and department association.

### 2. **Department Service**
Handles details of various departments within the organization.

### 3. **Organization Service**
Stores and manages organization-level details and aggregates employee and department data.

---

## 🌐 Supporting Components

### 4. **API Gateway**
Acts as the single entry point for all client requests, routing them to the appropriate services.

### 5. **Service Registry (Eureka)**
Used for service discovery to enable dynamic service registration and communication.

### 6. **Config Server**
Centralized external configuration management for all microservices.

---

## 📦 Tech Stack

- Java 17 / 21 / 22
- Spring Boot
- Spring Cloud (Eureka, Config, Gateway)
- REST APIs
- Maven / Gradle
- Lombok
- Postman for testing (optional)
- MySQL 

---
