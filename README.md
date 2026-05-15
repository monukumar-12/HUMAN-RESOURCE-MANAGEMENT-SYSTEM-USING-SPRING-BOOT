Human Resource Management System (HRMS)
Project Overview

This project is a Human Resource Management System developed using Java Spring Boot and Spring MVC. It is designed to manage departments and employees with proper validation, role-based access, and in-memory H2 database for testing.

The project is structured into two modules:

Department Management – CRUD operations for departments.

Employee Management – CRUD operations for employees.

The project follows a layered architecture: Controller → Service → Repository → Entity/DTO → Validation → Exception Handling.
Features
Department Management

Create, Read, Update, Delete departments

Input validation using Hibernate Validator

Exception handling

Employee Management

Create, Read, Update, Delete employees

Validation for all input fields

Role-based access (ADMIN / USER)

Exception handling

Common Features

Role-based access control – Only predefined roles allowed; invalid roles trigger an error

H2 in-memory database for quick development and testing

REST APIs tested using Postman

Layered architecture with separation of concerns

Technologies Used

Java 17+

Spring Boot

Spring MVC

Spring Validation (Hibernate Validator)

Spring Data JPA

H2 Database

Maven

Git / GitHub

Postman (for API testing)

Project Structure
HUMAN-RESOURCE-MANAGEMENT-SYSTEM-USING-SPRING-BOOT
│
├── department-management
│   ├── src
│   └── pom.xml
│
├── employee-management
│   ├── src
│   └── pom.xml
│
└── .gitignore

Running the Project

Clone the repository:

git clone https://github.com/monukumar-12/HUMAN-RESOURCE-MANAGEMENT-SYSTEM-USING-SPRING-BOOT.git
cd HUMAN-RESOURCE-MANAGEMENT-SYSTEM-USING-SPRING-BOOT


Open the project in IntelliJ IDEA or your preferred IDE.

Run the Spring Boot application:

mvn spring-boot:run


Access H2 console for database inspection:

http://localhost:8080/h2-console


JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: (leave blank)

API Endpoints
Department APIs
Method	Endpoint	Description
GET	/departments	Get all departments
GET	/departments/{id}	Get department by ID
POST	/departments	Create new department
PUT	/departments/{id}	Update department
DELETE	/departments/{id}	Delete department
Employee APIs
Method	Endpoint	Description
GET	/employees	Get all employees
GET	/employees/{id}	Get employee by ID
POST	/employees	Create new employee
PUT	/employees/{id}	Update employee
DELETE	/employees/{id}	Delete employee

Note: Only roles ADMIN and USER are allowed. Invalid roles trigger an error response.

Testing

All APIs tested using Postman

CRUD operations verified

Role-based access validated

H2 database confirmed to persist and retrieve data correctly



Author

Monu Kumar



GitHub: monukumar-12
