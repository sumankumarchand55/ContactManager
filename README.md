<h1>ContactManager - SpringBoot Project</h1>

<p>We have developed this ContactManager web application, which performs all fundamental CRUD operations related to managing contacts and user accounts. This application is designed with robust user authentication and authorization for enhanced security.</p>

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
    <td><img src="https://github.com/user-attachments/assets/98fbbde8-2c3b-42a4-9159-fa3840be50d4" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/cbcf45d8-c9b7-46f3-aba2-81c9c0681f52" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/560c550d-988e-4558-86cb-b8b6584c68b2" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/00242097-221c-4b91-9b2f-c02bc69262dc" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/46008db9-6a43-4b8c-9583-f3befcf02c22" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/4e6b1136-4cea-41af-8ffc-15b10786f0ba" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/1e553e30-4f2f-482f-a247-081afcb053d2" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/bcab16c4-75fa-4df7-8e70-0960ff44007f" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/47d691e5-1ff0-40d7-bdf3-e46463a831c3" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/5795a605-c635-43d0-b56e-813fd7dcf159" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/97bed7c2-c6e5-4b24-932d-c6fa318be067" width="800"/></td>
  </tr>
</table>

<h1>Desktop View - Direct Login Through Google</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/6d7a8875-537c-44ec-82c3-74a9607a4fc3" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/e2fe9da1-6159-457d-91b5-17bcd522f3c6" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/e9763d7a-6834-4b31-81e3-e3cfe2a6cc82" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/e2fe9da1-6159-457d-91b5-17bcd522f3c6" width="800"/></td>
  </tr>
    <tr>
    <td><img src="https://github.com/user-attachments/assets/e9763d7a-6834-4b31-81e3-e3cfe2a6cc82" width="800"/></td>
   <td><img src="https://github.com/user-attachments/assets/91eadfe0-ebad-4001-ada3-ec978f08df9e" width="800"/></td>
  </tr>
</table>

<h1>Desktop View - Manual Sign Up then Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/4d283e3e-59fa-4612-b3d4-8079dfa6c38c" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/2a65b543-a908-4a61-95b6-f880d18f1919" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/64ea2fa3-4554-490a-952f-a6ccfa21b287" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/aea66155-06d9-4d7c-80f3-f93b11b04104" width="800"/></td>
  </tr>
    <tr>
    <td><img src="https://github.com/user-attachments/assets/f51161f2-8be4-4aad-a8ac-880c39f89528" width="800"/></td>
   <td><img src="https://github.com/user-attachments/assets/7a95b487-b7b2-42bf-876b-354021807a6a" width="800"/></td>
  </tr>
  <tr>
   <td><img src="https://github.com/user-attachments/assets/ceee8c25-c973-4098-9ef3-77f80cb71cb1" width="800"/></td>
  </tr>
</table>

<h1>Desktop View - After Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/3f61323f-7ff8-483c-9658-ac3f458953c4" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/cb00f75f-eeb4-45a3-adeb-b381256afa40" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/4584713e-bf9d-42ef-a67c-06fde719b80e" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/4da445a2-8e1f-45df-96a4-5f919f486fd6" width="800"/></td>   
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/7f4641f7-fd55-464c-be1f-4483e7e618f8" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/5c21338c-aad2-4dcf-86fd-15d7b0ddef07" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/c8115a5b-c365-439a-aa3e-e3ab361887ef" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/682d04f4-0e38-4b45-bef0-41df332bbb0f" width="800"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/ab482a77-e7ce-4fbf-b884-a2db9bf5766d" width="800"/></td>
    <td><img src="https://github.com/user-attachments/assets/0a8d8f82-8292-4fb5-bc98-1d7594907890" width="800"/></td>
  </tr>
</table>

<h1>Mobile View - Before Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/1aac117b-cf3f-4fe9-ad60-784cb3bfd6d4" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/e600ff85-16f9-4bca-a164-8b9e3d40a0a0" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/320903ab-d92a-4b6b-aebd-88b2d5f49323" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/8ff60243-9180-47df-8ecc-094fcdaba68e" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/0835bb83-f8ee-4654-b446-e5be53e612ca" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/0a594b1c-a863-408c-9f45-b4b4065c1ac5" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/fd4f52ce-cc8a-4c73-b4ca-4bd597ed2edf" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/f2bf26b1-0272-4623-ac65-8b346d4f182c" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/f91dd6d4-8acd-4398-a84f-fb8ab9534bd8" width="200"/></td>
  </tr>
</table>


<h1>Mobile View -  Direct Login Through Google</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/b8d6fb57-0825-41b9-90c9-c4539b028940" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/bc9dd3b7-241f-4623-8d6e-c025b340a3f7" width="200"/></td>
   <td><img src="https://github.com/user-attachments/assets/e7bc9908-e2ff-474c-a708-2a5f08236fe9" width="200"/></td>
  </tr>
</table>

<h1>Mobile View - Manual Sign Up then Login</h1>

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/570c6719-fe52-4fc5-82b7-4ed2bdd9d9df" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/febc05ca-613c-49d0-9525-f9805767bc27" width="200"/></td>
   <td><img src="https://github.com/user-attachments/assets/97eef3f5-4d31-49c9-a9e2-bf66904dafcc" width="200"/></td>
  </tr>
   <tr>
    <td><img src="https://github.com/user-attachments/assets/6c015ca0-e62d-429f-be47-8ab2f41c56c6" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/e4d703c9-19a2-4d34-88b8-823d2905b1e2" width="200"/></td>
   <td><img src="https://github.com/user-attachments/assets/269873dd-f495-4742-b820-f3be0af9de11" width="200"/></td>
  </tr>
    <tr>
   <td><img src="https://github.com/user-attachments/assets/8a02dd23-2dff-4599-9259-331874097766" width="200"/></td>
  </tr>
</table>


<h1>Mobile View - After Login</h1>

<table>
  <tr>
   <td><img src="https://github.com/user-attachments/assets/e7bc9908-e2ff-474c-a708-2a5f08236fe9" width="200"/></td>
  <td><img src="https://github.com/user-attachments/assets/68c5108f-0bf0-4788-ab89-ef7949406314" width="200"/></td>
   <td><img src="https://github.com/user-attachments/assets/49b9534f-b33d-4c43-bc6b-6e6af777fa22" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/d6e23c4a-e95d-41a2-8ff4-dc067179d280" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/7f9585d1-4e6c-4998-9920-db16c90d01b1" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/4bf2f66f-1e76-49a4-96b2-82e1afc00956" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/6edaf149-728f-420c-9480-880e827f842f" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/7b8df3df-c2ad-438d-ab94-60bb47973864" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/b2942715-40ee-4978-9961-fd35522f5d8f" width="200"/></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/08ae35d5-6d10-419e-b420-b905c6b8ec86" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/7945582d-b08b-4bf4-8142-3a04e5b2dfa2" width="200"/></td>
    <td><img src="https://github.com/user-attachments/assets/163006d1-9081-4962-a804-bb54eab4aa78" width="200"/></td>
  </tr>
 <tr>
    <td><img src="https://github.com/user-attachments/assets/c504f304-153f-418f-9cbe-37cda9597d73" width="200"/></td>
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





                 



  
