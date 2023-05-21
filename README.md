# ElectricityBilling Backend

The ElectricityBilling Backend is a Java-based web application built with Spring Boot. It serves as the backend for the Billing Project, which is a frontend application built using React.

The backend application provides the necessary APIs and services for transmitting indexes and issuing invoices to the signed-up users.

## Key Features

- User management: The backend handles user registration, authentication, and authorization using Spring Security and JWT authentication.
- Index management: Users can transmit their electricity indexes, and the backend processes and stores the transmitted data using Postgre Docker and Flyway migrations.
- Invoice generation: Based on the transmitted indexes, the backend generates invoices and provides the necessary APIs for the frontend to retrieve and display them.
- Unit tests: The application includes JUnit 5 tests to ensure the reliability and correctness of the implemented functionalities.

## Technology Stack

The ElectricityBilling Backend is built using the following technologies and tools:

- Java 17: The programming language used for development.
- Spring Boot: The framework used for building the backend application.
- Maven: The build automation tool and dependency management system.
- PostgreSQL Docker: The containerized database used for storing data.
- Spring Security: The security framework used for user authentication and authorization.
- Flyway: The database migration tool used to manage database schema updates.
- JWT Authentication: The authentication mechanism used for securing the APIs.
- MapStruct: The Java-based code generation library used for mapping between objects.
- JUnit 5: The testing framework used for unit testing.

## Getting Started

To set up and run the ElectricityBilling Backend on your local machine, follow these steps:

1. Make sure you have Java 17 and Maven installed on your machine.
2. Clone the ElectricityBilling Backend repository.
3. Set up the PostgreSQL Docker container and configure the database connection.
4. Run the database migrations using Flyway to set up the required database schema.
5. Build the project using Maven: `mvn clean install`.
6. Start the backend server: `mvn spring-boot:run`.

## Set up the PostgreSQL Docker container 

1. Install Docker: Ensure that Docker is installed on your system. You can download and install Docker from the official Docker website (https://www.docker.com/).
2. Pull the PostgreSQL image: Open a terminal or command prompt and execute the following command to pull the PostgreSQL image from Docker Hub:
   ```
   docker pull postgres
   ```
3. Create a Docker container: Use the following command to create a new Docker container with PostgreSQL:
   ```
   docker run --name postgres-container -e POSTGRES_PASSWORD=your_password -p 5432:5432 -d postgres
   ```
   This command creates a container named "postgres-container" with the specified PostgreSQL password. It maps the container's port 5432 to the host machine's port 5432, allowing you to access the database from your local environment.
4. Verify the container status: You can check the status of your container by running the following command:
   ```
   docker ps -a
   ```
   This command lists all containers on your system. Make sure that the PostgreSQL container is in a running state.
5. Connect to the PostgreSQL container: You can connect to the PostgreSQL container using a database client tool (e.g., pgAdmin, DBeaver). Use the following connection details:
   - Host: localhost
   - Port: 5432
   - Username: postgres
   - Password: the password you specified in step 3
6. Create and manage databases: Once connected to the PostgreSQL container, you can create and manage databases using SQL commands or a database management tool.

That's it! You now have a PostgreSQL container up and running. You can use this container for your application's database needs. Remember to configure your application's database connection settings to connect to the PostgreSQL container using the provided host, port, username, and password.

## Testing

The application includes a comprehensive suite of JUnit 5 tests. To run the tests, execute the following command:

```
mvn test
```

