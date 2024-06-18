# CRM Full Stack Application

This project is a Customer Relationship Management (CRM) application with a full-stack architecture using Angular for the frontend, Spring Boot for the backend, and PostgreSQL for the database.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Backend Setup](#backend-setup)
- [Frontend Setup](#frontend-setup)
- [Database Setup](#database-setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Features

- User Management: Create, update, delete, and view users.
- Project Management: Create, assign, update, and delete projects. Track project updates, deadlines, and payments. Revoke projects if necessary.
- CRM Functionality: User listing, detailed user view, and project linking.
- Usage Monitoring: Log and monitor application usage and user actions.
- Authentication and Authorization: Implemented user authentication and role-based authorization (admin, standard user).

## Technologies Used

- Frontend: Angular
- Backend: Spring Boot
- Database: PostgreSQL

## Getting Started

Follow these instructions to set up and run the project locally.

### Prerequisites

- Node.js and npm (for Angular)
- Java JDK 11 or higher (for Spring Boot)
- PostgreSQL

## Backend Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    cd your-repo-name/backend
    ```

2. Configure PostgreSQL database in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/crm_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

3. Build and run the backend application:
    ```bash
    ./mvnw spring-boot:run
    ```

## Frontend Setup

1. Navigate to the frontend directory:
    ```bash
    cd ../frontend
    ```

2. Install the dependencies:
    ```bash
    npm install
    ```

3. Run the frontend application:
    ```bash
    ng serve
    ```

4. Open your browser and navigate to `http://localhost:4200`.

## Database Setup

1. Create a PostgreSQL database named `crm_db`.
2. Add the necessary tables and initial data:
    ```sql
    -- Users table
    CREATE TABLE users (
        id SERIAL PRIMARY KEY,
        username VARCHAR(100) NOT NULL,
        password VARCHAR(100) NOT NULL,
        role VARCHAR(50) NOT NULL
    );

    -- Projects table
    CREATE TABLE projects (
        id SERIAL PRIMARY KEY,
        project_name VARCHAR(100) NOT NULL,
        description TEXT,
        user_id INTEGER REFERENCES users(id)
    );

    -- Insert sample data
    INSERT INTO users (username, password, role) VALUES
    ('user1', 'password1', 'admin'),
    ('user2', 'password2', 'user'),
    ('user3', 'password3', 'user');

    INSERT INTO projects (project_name, description, user_id) VALUES
    ('Project 1', 'Description for project 1', 1),
    ('Project 2', 'Description for project 2', 2),
    ('Project 3', 'Description for project 3', 3);
    ```

## Usage

- Navigate to `http://localhost:4200` to access the frontend application.
- Use the user and project management features to interact with the application.

## API Endpoints

### User Endpoints

- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update user by ID
- `DELETE /api/users/{id}` - Delete user by ID

### Project Endpoints

- `GET /api/projects` - Get all projects
- `GET /api/projects/{id}` - Get project by ID
- `POST /api/projects` - Create a new project
- `PUT /api/projects/{id}` - Update project by ID
- `DELETE /api/projects/{id}` - Delete project by ID
