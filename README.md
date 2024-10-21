Smart Contact Manager - SpringBoot Project
We have developed this REST API for the ContactManager web application. This API performs all the fundamental CRUD operations related to managing contacts and user accounts,
with robust user authentication and authorization for security.

This project is developed solely by Suman Kumar Chand and his team during personal project work.

E-R Diagram for the Application
E-R Diagram: 
![Screenshot 2024-10-21 155156](https://github.com/user-attachments/assets/803db8ec-d297-4e4b-b746-8d9cfbcc5efe)

Tech Stack
Java
Spring Framework
Spring Boot
Spring Data JPA
Hibernate
MySQL
Modules
User Authentication and Authorization
User Management Module
Contact Management Module
Session Management Module
Features
User Authentication:
Registration, login, and logout functionalities for users.
Session-based authentication with a token that expires after 1 hour for enhanced security.
User Features:
Register: Users can sign up and create an account.
Login: Users can log in using valid credentials.
View & Update Profile: Logged-in users can update their personal information like password, email, phone number, etc.
Manage Contacts: Users can add, update, delete, and view their contacts.
Contributors
Suman Kumar Chand (Developer, Student)
Installation & Run
Before running the API server, make sure to update the database configuration inside the application.properties file:

properties
Copy code
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/contactmanagerdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
API Root Endpoint
https://localhost:8080/
Swagger UI: http://localhost:8080/swagger-ui/index.html
API Module Endpoints
Authentication Module
POST /register: Register a new user.
POST /login: Log in a user with valid credentials.
POST /logout: Log out a user based on the session token.
User Module
GET /user/current: Retrieve details of the currently logged-in user.
PUT /user/update/password: Update the logged-in user’s password.
PUT /user/update/email: Update the logged-in user’s email.
DELETE /user: Delete the currently logged-in user’s account.
Contact Module
GET /contacts: Retrieve all contacts of the logged-in user.
POST /contacts/add: Add a new contact.
PUT /contacts/{id}: Update an existing contact by ID.
DELETE /contacts/{id}: Delete a contact by ID.
Sample API Response for User Login
POST localhost:8080/login

Request Body
json
Copy code
{
    "email": "example@example.com",
    "password": "password123"
}
Response
json
Copy code
{
    "sessionId": 23,
    "token": "user_123456789",
    "userId": 19,
    "sessionStartTime": "2023-10-21T10:48:20.0109626",
    "sessionEndTime": "2023-10-21T11:48:20.0109626"
}
