# Employee Management System

A RESTful Employee Management System built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. This application provides APIs to create, retrieve, update, and soft delete employee records.

## 🚀 Features

- Create a new employee
- Retrieve all active employees
- Get employee by ID
- Update employee details
- Soft delete employees
- Input validation
- Global exception handling
- Pagination and sorting support
- Layered architecture (Controller → Service → Repository → Database)

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- MySQL
- Hibernate
- Lombok
- REST APIs
- Postman

## 📁 Project Structure

```
src
 ├── main
 │   ├── java
 │   │   ├── controller
 │   │   ├── service
 │   │   ├── repository
 │   │   ├── entity
 │   │   ├── exception
 │   │   └── EmployeeManagementApplication.java
 │   └── resources
 │       └── application.properties
 └── test
```

## 📌 REST API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/employees` | Create Employee |
| GET | `/employees` | Get All Employees |
| GET | `/employees/{id}` | Get Employee By ID |
| PUT | `/employees/{id}` | Update Employee |
| DELETE | `/employees/{id}` | Soft Delete Employee |

## ⚙️ How to Run

1. Clone the repository

```bash
git clone https://github.com/your-username/employee-management.git
```

2. Open the project in IntelliJ IDEA or Eclipse.

3. Configure your MySQL database in `application.properties`.

4. Run the application.

5. Test the APIs using Postman.

## 🧪 Sample JSON Request

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "department": "IT",
  "salary": 50000
}
```

## 📚 Architecture

```
Client (Postman)
        │
        ▼
Controller
        │
        ▼
Service
        │
        ▼
Repository
        │
        ▼
MySQL Database
```

## 👨‍💻 Author

**Suriyabhuvanesh E**

GitHub: https://github.com/suriyabhuvanesh-e1812
