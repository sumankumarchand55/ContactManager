<h1>ContactManager - SpringBoot Project</h1>

<p>I developed this ContactManager web application, which performs all fundamental CRUD operations related to managing contacts and user accounts. This application is designed with robust user authentication and authorization for enhanced security.</p>

<p>This project is developed solely by <strong>Suman Kumar Chand</strong> during personal project work.</p>

<h2>E-R Diagram for the Application</h2>
<p>E-R Diagram:</p>
<img src="https://github.com/user-attachments/assets/803db8ec-d297-4e4b-b746-8d9cfbcc5efe" alt="E-R Diagram" />

<h2>Tech Stack</h2>
<ul>
  <li>Java</li>
  <li>Spring Framework</li>
  <li>Spring Boot</li>
  <li>Spring Data JPA</li>
  <li>Hibernate</li>
  <li>Oracle SQL DB</li>
</ul>
<h2>Other Knowledge</h2>
<ul>
  <li>Spring Tool Suite</li>
  <li>Mail SMTP</li>
  <li>Google Oauth</li>
  <li>HTML, CSS, Bootstrap & JavaScript</li>
  <li>Github</li>
</ul>

<h2>Modules</h2>
<ul>
  <li><strong>User Authentication and Authorization:</strong> Registration, login, and personalized access.</li>
  <li><strong>User Management Module:</strong> Create, update, view, and disable user accounts.</li>
  <li><strong>Contact Management Module:</strong> Create, read, update, and delete contacts with options to mark as favorites.</li>
  <li><strong>Dynamic Search Functionality:</strong> Real-time search across contacts and user data.</li>
</ul>

<h2>Features</h2>

<h3>User Authentication</h3>
<p>The application includes registration, login, and logout functionalities for users, with a "forgot password" option. It uses Spring Security for authentication and authorization to ensure personalized access to user data.</p>

<h2>User Features</h2>
<ul>
  <li><strong>Register:</strong> Users can sign up and create accounts either manually or through Google authentication.</li>
  <li><strong>Login:</strong> Users can log in with valid credentials or through Google sign-in.</li>
  <li><strong>View & Update Profile:</strong> Logged-in users can view and update their personal information, such as password, phone number, profile image, D.O.B, name, and more.</li>
  <li><strong>Manage Contacts:</strong> Users can add, update, delete, and view their contacts with ease.</li>
</ul>

<h2>Contributors</h2>
<p><strong>Suman Kumar Chand</strong> (Developer, Student)</p>

<h2>Installation & Run</h2>
<p>Before running the API server, ensure to update the database configuration in the <code>application.properties</code> file:</p>

<h3>Properties Configuration:</h3>
<pre>
server.port=8080
spring.datasource.url=jdbc:oracle:thin:@//MSI:1521/orcl
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.username=...
spring.datasource.password=..
</pre>

<h1>All Page Details</h1>

<h3>Root Endpoint</h3>
<p>https://localhost:8080/</p>

<h3>Without Authentication Pages</h3>
<ul>
  <li>https://localhost:8080/about: About Page</li>
  <li>https://localhost:8080/service: Service Page</li>
  <li>https://localhost:8080/contact: Contact Page</li>
  <li>https://localhost:8080/meetus: Meet Our Team Page</li>
  <li>https://localhost:8080/gallery: Our Gallery</li>
</ul>

<h3>Authentication Pages</h3>
<ul>
  <li>https://localhost:8080/signup: Register a new user Page</li>
  <li>https://localhost:8080/login: Log in a user with valid credentials Page</li>
  <li>https://localhost:8080/logout: Log out a user</li>
  <li>http://localhost:8080/auth/forgot-password: Forgot Password Page</li>
</ul>

<h3>User After Login Pages</h3>
<ul>
  <li>http://localhost:8080/user/index: User Dashboard Page</li>
  <li>http://localhost:8080/user/profile: User Profile Details Page with Change Password Modal</li>
  <li>http://localhost:8080/user/contacts: View All Contacts Page (includes Update, Delete, view modal, and export features)</li>
  <li>http://localhost:8080/user/contacts/add: Create New Contact Page</li>
  <li>http://localhost:8080/user/contacts/favorites: Favorite Contacts Page</li>
  <li>http://localhost:8080/user/contacts/search?field=firstName&keyword=suman: Search Result Page</li>
</ul>

<h1>EXPLORE WEBSITE</h1>

<h1>Desktop View - Before Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/0a44c5a3-a7b4-4c38-be5f-98ebeb3b9d21" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/aff1ffb1-9195-4319-85b7-b0935c08de40" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/1b402e16-a789-41a1-aa9b-7b79408b4a01" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/a5eeaee9-0a59-4ddf-9afc-024470e2c211" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/2f0a9d83-d883-45b1-bafc-4940d7d63956" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/eb8a76ed-5424-4ccd-b5d3-a3d8555ad0fe" width="800"/></td>
  </tr>
</table>


<h1>Desktop View - Sign Up then Login and sign-in with google</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/9d0fab08-a5cf-45c6-a2c6-38f0f099623c" width="800"/></td>
  <td><img src="https://github.com/user-attachments/assets/2a65b543-a908-4a61-95b6-f880d18f1919" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/64ea2fa3-4554-490a-952f-a6ccfa21b287" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/aea66155-06d9-4d7c-80f3-f93b11b04104" width="800"/></td>
   
  </tr>
   <td><img src="https://github.com/user-attachments/assets/a4f412b1-483b-480b-84d0-c022f1120ff6" width="800"/></td>
   <td><img src="https://github.com/user-attachments/assets/2ce2e27a-ad4c-4a96-9bbe-66a3fe0d6a14" width="800"/></td>
    <tr>
 
  </tr>
</table>
  
<h1>Desktop View - After Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/6e24c1a3-0136-44d3-802e-97512b72964a" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/ab4f3e0b-7a2e-42b7-96a4-900719b0d11b" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/2d498107-f7c5-4d0b-a53c-95a22770724f" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/ef87e1b2-67ce-4371-ac1d-d447445a93dc" width="800"/></td>   
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/4c773fd5-3b9f-4a94-bca9-bb59bfe05888" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/8bf3d702-a108-4b65-b18e-1c652cf2d2a6" width="800"/></td>
  </tr>
</table>


<h1>Mobile View - Before Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/c916bda4-7ab8-4eef-bc26-181b8e99f8e8" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/0225daed-d1ab-4745-96aa-c954f8796bea" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/fd1a4658-20a6-4399-a078-29253dfd2b6d" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/1509f383-eeb8-4e37-9874-9d5e898d152c" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/913c56e9-8a64-48d3-a00e-0fddd9f06bf5" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/223d1f61-ff04-43c8-80ab-d890b13a54c2" width="200"/></td>
  </tr>
</table>

<h1>Mobile View - register and Login or continue with google</h1>

<table>

   <tr>
    <td><img src="https://github.com/user-attachments/assets/ad2f6d90-cb77-4686-b842-48faac954fff" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/08e85743-bc26-46d0-85a8-1b8bf6968751" width="200"/></td>
  </tr>
</table>

<h1>Mobile View - After Login</h1>

<table>
  <tr>
   <td><img src="https://github.com/user-attachments/assets/2438e7ec-d876-45eb-827f-eb9c31cd8539" width="200"/></td>
  <td><img src="https://github.com/user-attachments/assets/cf8b6cd6-3ade-4911-bb0a-fc82ca252d15" width="200"/></td>
   <td><img src="https://github.com/user-attachments/assets/c423890b-9568-4b37-8944-d86c77dd1738" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/9c774fcb-16ce-4104-a2ef-f03aba338c55" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/0a3fc3e3-2651-4693-aa5f-8ed0b5a9cacd" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/f94c2678-6e28-4745-8fde-62b5a7defc51" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/012bc28e-5fef-4bd4-83e4-5082b70e368c" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/2f765f2b-fdf9-4c9f-8ec2-95c913868a3e" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/65ff003e-cab3-4909-b122-5d6296015f6d" width="200"/></td>
  </tr>
 <tr>
    <td><img src="https://github.com/user-attachments/assets/40abb474-c2c7-4ebf-9672-f0ea84faa973" width="200"/></td>
  </tr>
</table>

<h1>Mobile View - Forgot Account Password</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/2c1f10e8-9050-4057-be31-6b5a15a6ebb9" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/ccda78dc-bfc1-4fca-8f6f-4d57c202c144" width="200"/></td>
   <td><img src="https://github.com/user-attachments/assets/5a8b268a-cdde-423a-ab95-285e76cf0b5f" width="200"/></td>
  </tr>
   <tr>
    <td><img src="https://github.com/user-attachments/assets/45390821-6c16-483b-851c-a1b4202ae9c5" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/4b003cd9-0596-4ada-a505-371818ad26de" width="200"/></td>
  </tr>
</table>
                      <h5 style="text-align: center; font-weight: bold; font-size: 1rem; margin: 0; padding: 10px 0;">
                           ContactManager.fun © 2024 Copyright, All Rights Reserved
                       </h5>





                 



  
