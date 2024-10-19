## Prerequisites
Java Development Kit (JDK) 22.
Maven.
MySQL database.
## Database Configuration
Create a database named \`registrationdb\`. 
    (or your chosen name) .
modify the database name `assignment/src/main/resources/application.properties` :spring.datasource.url=jdbc:mysql://localhost:3306/registrationdb replace the registrationdb with your database name.
## Setup and Running the Application
Navigate to the assignment directory: cd assignment.
Build the project: mvn clean install.
Run the Spring Boot application:The assignment server should now be running on `http://localhost:8080`.
### Frontend
As Thymeleaf is integrated with Spring Boot, the frontend will be served by the backend server. You don't need to run it separately.
## Accessing the Application
Open your web browser and go to `http://localhost:8080`.
make sure your pc is connected to the internet.
