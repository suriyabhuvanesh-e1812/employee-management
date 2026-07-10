# Employee Management System with JWT Authentication

A secure Employee Management System built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **Spring Data JPA**, and **MySQL**. The application provides REST APIs to manage employee records with role-based access control.

---

## 🚀 Features

### Employee Management
- Create Employee
- Get All Employees
- Get Employee by ID
- Update Employee
- Soft Delete Employee
- Search Employee by Department
- Pagination
- Sorting

### Authentication & Security
- User Registration
- User Login
- JWT Token Generation
- Spring Security Integration
- BCrypt Password Encryption
- Role-Based Authorization (ADMIN)
- Protected REST APIs

### Other Features
- DTO Pattern
- Layered Architecture
- Global Exception Handling
- Request Validation
- Logging
- RESTful API Design

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman

---

## 📂 Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── security
 ├── exception
 ├── specification
 └── resources
```

---

## 🔐 Authentication Flow

1. Register a new user.
2. Login using username and password.
3. Receive a JWT token.
4. Include the token in the Authorization header:

```
Authorization: Bearer <JWT_TOKEN>
```

5. Access protected Employee APIs.

---

## 📌 REST API Endpoints

### Authentication APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/auth/register` | Register User |
| POST | `/api/auth/login` | Login & Generate JWT |

### Employee APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/employees` | Create Employee |
| GET | `/api/employees` | Get All Employees |
| GET | `/api/employees/{id}` | Get Employee By ID |
| PUT | `/api/employees/{id}` | Update Employee |
| DELETE | `/api/employees/{id}` | Soft Delete Employee |
| GET | `/api/employees/search?department=IT` | Search by Department |

---

## 🗄️ Database

Database Name

```
employee_management
```

Tables

- employees
- users

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone https://github.com/suriyabhuvanesh-e1812/employee-management.git
```

2. Open the project in IntelliJ IDEA or Eclipse.

3. Configure MySQL in `application.properties`.

4. Run the Spring Boot application.

5. Test APIs using Postman.

---

## 📸 API Testing

Use Postman to test:

- Register User
- Login
- Generate JWT Token
- Access Employee APIs using Bearer Token

---

## 📖 Architecture

```
                Client (Postman)
                       │
                       ▼
              Spring Security
                       │
                 JWT Filter
                       │
                 Controller
                       │
                   Service
                       │
                 Repository
                       │
                     MySQL
```

---

## 📚 Key Concepts Implemented

- CRUD Operations
- REST APIs
- Layered Architecture
- DTO Pattern
- Spring Security
- JWT Authentication
- Role-Based Authorization
- BCrypt Password Encoding
- Validation
- Exception Handling
- Pagination
- Sorting
- Logging

---

## 👨‍💻 Author

**Suriyabhuvanesh E**

GitHub: https://github.com/suriyabhuvanesh-e1812

---

⭐ If you found this project useful, consider giving it a star.
