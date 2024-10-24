
# Task Management API

The Task Management System backend is a standalone application designed to handle the logic and data management  for managing tasks. It provides a set of APIs to perform CRUD operations on tasks and includes authentication, authorization, validation, and other features.
## Features

- **User Management**: Secure user authentication using JWT (JSON Web Tokens).
- **Task Management**: Create, update, delete, and retrieve tasks.
- **Validation**: Input validation for API requests.
- **Error Handling**: Global exception handling using `@ControllerAdvice`.
- **Security**: JWT-based security for API endpoints.
- **Swagger**: API documentation and testing via Swagger UI.

## Technologies Used

- **Spring Boot**: Core framework for building the API.
- **JWT**: Used for securing endpoints and user authentication.
- **Hibernate/JPA**: For ORM and database interaction.
- **PostgreSQL**: Database for persisting data.
- **Swagger**: API documentation.
- **Maven**: For managing dependencies.
- **MapStruct**: code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach.
- **flyway**: For migrate database changes.
- **Docker**: Containerization for microservices.

## Prerequisites

- JDK 11 or higher
- Maven
- PostgreSQL
- Docker (optional, for containerization)

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git git@github.com:mohammed-a-wadod/challenge05.git
   cd task-management
   ```

2. **Update database configurations**:
   Add valid Database url, database username, and database password in the environment variable:
   ```properties
   spring.datasource.url=${DB_URL}
   spring.datasource.username=${DB_USER}
   spring.datasource.password=${DB_PASSWORD}
   ```
3. **Update email configurations**: Add valid email and password in application.properties, take into consideration the following:
- turn of the second factor auth.
- make the account less secure to enable the demo to send email to your clinet.

4. **Build and run the application**:
   Run the following commands to build and run the app:
   ```bash
   mvn clean install -DskipTests
   mvn spring-boot:run
   ```

5. **Access the API documentation**:
   Once the application is running, you can access the Swagger UI at:
   ```
   http://localhost:8080/swagger-ui.html
   ``` 

## API Endpoints

### Authentication

- **Login**: `POST /auth/login`

### Task Management

- **Get all tasks for admin only**: `GET /api/tasks/admin/all-tasks`
- **Search task by search criteria**: `POST /api/tasks/search`
- **Get a task by id**: `GET /api/tasks/{id}`
- **Create a task**: `POST /api/tasks`
- **Update a task**: `PUT /api/tasks/{id}`
- **Delete a task**: `DELETE /api/tasks/{id}`

There is postman collection file which conatians all the APIs

## Security

There is predefinded users that can be used for testing:
1. username: admin - passoword: 12345
2. username: user - passoword: 12345

All task-related endpoints require a valid JWT token in the `Authorization` header:
```
Authorization: Bearer <your-token>
```

## Running the app

Run task management service by one of the following

1. Running Task Management service as standalone application:
   ```bash
   java -jar task-management-service.jar
   ```
   or us this command
   ```bash
   mvn spring-boot:run
   ```
   
2. Build the Docker image and run the Docker container:
   ```bash
   docker build -t task-management-service -f task-management-service.dockerfile .
   docker run -p 8080:8080 task-management-service
   ```

3. Using docker-compose:
   ```bash
   docker-compose up --build -d --remove-orphans
   ```
