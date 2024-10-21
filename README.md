Smart Contact Manager - SpringBoot Project
We have developed this REST API for the ContactManager web application. This API performs all the fundamental CRUD operations related to managing contacts and user accounts,
with robust user authentication and authorization for security.

This project is developed solely by Suman Kumar Chand and his team during personal project work.

E-R Diagram for the Application
image link:https://res.cloudinary.com/dk7kmizvr/image/upload/v1729506505/itvczzhklhfbx84ojf5u.png
E-R Diagram: 
![Screenshot 2024-10-21 155156](https://github.com/user-attachments/assets/803db8ec-d297-4e4b-b746-8d9cfbcc5efe)
Tech Stack
Java
Spring Framework
Spring Boot
Spring Data JPA
Hibernate
Oracle DB

<h1>Modules</h1>
User Authentication and Authorization
User Management Module
Contact Management Module
Create,read,update and add to favorite to contacts.
Dynamic Search Functionality

<h1>Features</h1>
User Authentication:
Registration, login, and logout functionalities for users with forgot password option.
User Spring security for Authentication and AuthoriZation for personalize data.

<h1>User Features:</h1>
Register: Users can sign up and create an account mannually or direct through Google.
Login: Users can log in using valid credentials or direct through Google.
View & Update Profile: Logged-in users can view and update their personal information like password, phone number,profile image,D.O.B,Name etc.
Manage Contacts: Users can add, update, delete, and view their contacts.

<h1>Contributors</h1>
Suman Kumar Chand (Developer, Student)
Installation & Run
Before running the API server, make sure to update the database configuration inside the application.properties file:

<h1>properties</h1>
Copy code
server.port=8080
spring.datasource.url=jdbc:oracle:thin:@//MSI:1521/orcl
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.username=...
spring.datasource.password=..

 <h1>All Page Details</h1>

<h3>Root Endpoint</h3>
https://localhost:8080/

<h3>Without Authentication Pages</h3>
https://localhost:8080/about:About Page
https://localhost:8080/service:Service Page
https://localhost:8080/contact:Contact Page
https://localhost:8080/meetus:Meet Out Team Page
https://localhost:8080/gallery:Our Gallery

<h3>Authentication Pages</h3>
https://localhost:8080/signup: Register a new user Page.
https://localhost:8080/login: Log in a user with valid credentials Page.
https://localhost:8080/logout: Log out a user.
http://localhost:8080/auth/forgot-password:Forgot Password Page

<h3>User After Login Pages</h3>
http://localhost:8080/user/index:User Dash-board Page
http://localhost:8080/user/profile: User Profile Details Page with Change Password Modal.
http://localhost:8080/user/contacts: User View All Contact Page and also Update And Delete and view their by modal and export as well.
http://localhost:8080/user/contacts/add:Create New Contact after Login Page 
http://localhost:8080/user/contacts/favorites: Favorite Contacts Page.
http://localhost:8080/user/contacts/search?field=firstName&keyword=suman:Search result after searching Page

  Screen Shots of website Desktop view 
  
