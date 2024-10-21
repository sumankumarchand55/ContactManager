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

 <h1> Screen Shots of website Desktop view Before login</h1>
 ![Screenshot]()
 
![Screenshot 2024-10-21 164254](https://github.com/user-attachments/assets/98fbbde8-2c3b-42a4-9159-fa3840be50d4)
![Screenshot 2024-10-21 164406](https://github.com/user-attachments/assets/cbcf45d8-c9b7-46f3-aba2-81c9c0681f52)
![Screenshot 2024-10-21 164441](https://github.com/user-attachments/assets/560c550d-988e-4558-86cb-b8b6584c68b2)
![Screenshot 2024-10-21 164512](https://github.com/user-attachments/assets/00242097-221c-4b91-9b2f-c02bc69262dc)
![Screenshot 2024-10-21 164547](https://github.com/user-attachments/assets/46008db9-6a43-4b8c-9583-f3befcf02c22)
![Screenshot 2024-10-21 164618](https://github.com/user-attachments/assets/4e6b1136-4cea-41af-8ffc-15b10786f0ba)
![Screenshot 2024-10-21 164643](https://github.com/user-attachments/assets/bcab16c4-75fa-4df7-8e70-0960ff44007f)
![Screenshot 2024-10-21 164730](https://github.com/user-attachments/assets/47d691e5-1ff0-40d7-bdf3-e46463a831c3)
![Screenshot 2024-10-21 164756](https://github.com/user-attachments/assets/5795a605-c635-43d0-b56e-813fd7dcf159)
![Screenshot 2024-10-21 164841](https://github.com/user-attachments/assets/97bed7c2-c6e5-4b24-932d-c6fa318be067)

 <h1> Screen Shots of website Desktop view login & Signup</h1>

 ![Screenshot 2024-10-21 164921](https://github.com/user-attachments/assets/343a5e3b-9915-4f59-b055-84103759dc76)
 ![Screenshot 2024-10-21 165023](https://github.com/user-attachments/assets/6d7a8875-537c-44ec-82c3-74a9607a4fc3)
![Screenshot 2024-10-21 165122](https://github.com/user-attachments/assets/e2fe9da1-6159-457d-91b5-17bcd522f3c6)
![Screenshot 2024-10-21 165149](https://github.com/user-attachments/assets/e9763d7a-6834-4b31-81e3-e3cfe2a6cc82)

 <h1> Screen Shots of website After Login</h1>










  
