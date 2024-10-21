<h1>ContactManager - SpringBoot Project</h1>
We have developed this ContactManager web application. This API performs all the fundamental CRUD operations related to managing contacts and user accounts,
with robust user authentication and authorization for security.

This project is developed solely by Suman Kumar Chand and during personal project work.

E-R Diagram for the Application
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

<h1>Screen Shots of Website Desktop View Before Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/98fbbde8-2c3b-42a4-9159-fa3840be50d4" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/cbcf45d8-c9b7-46f3-aba2-81c9c0681f52" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/560c550d-988e-4558-86cb-b8b6584c68b2" width="300"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/00242097-221c-4b91-9b2f-c02bc69262dc" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/46008db9-6a43-4b8c-9583-f3befcf02c22" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/4e6b1136-4cea-41af-8ffc-15b10786f0ba" width="300"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/bcab16c4-75fa-4df7-8e70-0960ff44007f" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/47d691e5-1ff0-40d7-bdf3-e46463a831c3" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/5795a605-c635-43d0-b56e-813fd7dcf159" width="300"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/97bed7c2-c6e5-4b24-932d-c6fa318be067" width="300"/></td>
  </tr>
</table>

<h1>Screen Shots of Website Desktop View Login & Signup</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/343a5e3b-9915-4f59-b055-84103759dc76" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/6d7a8875-537c-44ec-82c3-74a9607a4fc3" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/e2fe9da1-6159-457d-91b5-17bcd522f3c6" width="300"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/e9763d7a-6834-4b31-81e3-e3cfe2a6cc82" width="300"/></td>
  </tr>
</table>

<h1>Screen Shots of Website Desktop View After Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/3f61323f-7ff8-483c-9658-ac3f458953c4" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/cb00f75f-eeb4-45a3-adeb-b381256afa40" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/4584713e-bf9d-42ef-a67c-06fde719b80e" width="300"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/4da445a2-8e1f-45df-96a4-5f919f486fd6" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/7f4641f7-fd55-464c-be1f-4483e7e618f8" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/5c21338c-aad2-4dcf-86fd-15d7b0ddef07" width="300"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/c8115a5b-c365-439a-aa3e-e3ab361887ef" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/682d04f4-0e38-4b45-bef0-41df332bbb0f" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/ab482a77-e7ce-4fbf-b884-a2db9bf5766d" width="300"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/0a8d8f82-8292-4fb5-bc98-1d7594907890" width="300"/></td>
  </tr>
</table>

<h1>Screen Shots of Website Mobile View Before Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/320903ab-d92a-4b6b-aebd-88b2d5f49323" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/e600ff85-16f9-4bca-a164-8b9e3d40a0a0" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/1aac117b-cf3f-4fe9-ad60-784cb3bfd6d4" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/8ff60243-9180-47df-8ecc-094fcdaba68e" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/0835bb83-f8ee-4654-b446-e5be53e612ca" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/0a594b1c-a863-408c-9f45-b4b4065c1ac5" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/f2bf26b1-0272-4623-ac65-8b346d4f182c" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/fd4f52ce-cc8a-4c73-b4ca-4bd597ed2edf" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/f91dd6d4-8acd-4398-a84f-fb8ab9534bd8" width="200"/></td>
  </tr>
</table>


<h1>Screen Shots of Website Mobile View - Login & Signup</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/5e135d51-bcbe-41cb-8103-15d4ba3517e1" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/b8d6fb57-0825-41b9-90c9-c4539b028940" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/bc9dd3b7-241f-4623-8d6e-c025b340a3f7" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/c6467750-535a-4ca4-bbac-00703c3ca820" width="200"/></td>
  </tr>
</table>


<h1>Screen Shots of Website Mobile View - After Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/bfca70f1-154d-4ab7-b0fe-bfbe2c920f08" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/de9c0c18-dbe6-42af-807c-44101f67376b" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/6a7f22ad-a9d3-4cf2-864c-bc6a8b7ba2ae" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/6edaf149-728f-420c-9480-880e827f842f" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/d6e23c4a-e95d-41a2-8ff4-dc067179d280" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/7f9585d1-4e6c-4998-9920-db16c90d01b1" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/a8c2770e-aece-4928-b6f0-038e3d739c72" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/7b8df3df-c2ad-438d-ab94-60bb47973864" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/b2942715-40ee-4978-9961-fd35522f5d8f" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/08ae35d5-6d10-419e-b420-b905c6b8ec86" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/7945582d-b08b-4bf4-8142-3a04e5b2dfa2" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/163006d1-9081-4962-a804-bb54eab4aa78" width="200"/></td>
  </tr>
</table>








  
