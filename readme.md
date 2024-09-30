# JobHive - Professional Networking and Job Search Platform

JobHive is a professional networking platform built using Spring Boot and MySQL, similar to platforms like LinkedIn. 

![Project Homepage](image.png)

# 📑 Table of Contents

1. [Project Description](#-project-description)
2. [Features Implemented](#️-features-implemented)
3. [Technical Stack](#-technical-stack)
4. [Project Setup and Installation Instructions](#-project-setup-and-installation-instructions)
   - [Prerequisites](#prerequisites)
   - [Installation Steps](#installation-steps)
5. [How to Use JobHive Platform](#-how-to-use-jobhive-platform)
   - [Register or Login](#register-or-login)
   - [Set Up Your Profile](#set-up-your-profile)
   - [Search for Jobs](#search-for-jobs)
   - [Apply for Jobs](#apply-for-jobs)
   - [Connect with Professionals](#connect-with-professionals)
   - [Create or Interact with Posts](#create-or-interact-with-posts)
   - [Send Messages](#send-messages)
   - [Receive Notifications](#receive-notifications)
6. [Project Structure](#-project-structure)
7. [Contributing](#-contributing)
8. [Show your support](#-show-your-support)
9. [License](#-license)


## 📖 Project Description

JobHive is a professional networking platform built using **Spring Boot and MySQL**, similar to platforms like LinkedIn. The platform enables users to connect with professionals, build detailed profiles, search for job listings, and communicate directly via messaging.

JobHive is designed to provide a seamless experience for professionals looking to enhance their careers. With features like AI-driven job recommendations and customizable networking, the platform connects users based on industries, skills, and interests. Employers can post jobs, review applications, and manage candidates.

This platform was developed as part of an Advanced Diploma course at the **National Skill Training Institute, Bengaluru**.

## 🛠️ Features Implemented

1. **User Registration and Authentication**:
   - Users can register for an account.
   - Existing users can log in using their email and password.
   - A verification email must be sent after registration to confirm user identity.
   - User can log out and end their session.

2. **User Profile Creation**:
   - Users should create and update their professional profiles, including personal details, skills, education, and work experience.
   - Users can upload profile and background images to enhance their profiles.

   
3. **Content Interaction**:
   - Users should create and share posts, articles, and events.
   - The ability to like, comment, and reply to comments on posts and articles.

   
4. **Search Functionality**:
   - Users should search for posts, articles, events, and other users easily.
   - Filters should be available to refine search results.


5. **Connection Management**:
   - Users should connect with other users by sending and accepting connection requests.
   - Users can follow or unfollow others to manage their feeds.


6. **Messaging System**:
   - Users should send private messages to their connections.
   - Notifications for new messages and interactions (likes, comments) on posts.


7. **Job Listings**:
   - Users should browse job postings, apply for jobs, and upload resumes.
   - Employers can view applicants and manage job listings

   
8. **Notification System**:
   - Connections are notified when a user creates a new post, ensuring engagement.
   - Users receive notifications when their posts are commented on or liked.

## 🚀 Technical Stack

- **Backend**: Java, Spring Boot, Hibernate (JPA)
- **Frontend**: Thymeleaf (HTML templates), Bootstrap, HTML, CSS
- **Database**: MySQL
- **Build Tool**: Maven
- **Image Handling**: Images are stored as `byte[]` directly in the database.


## 📦 Project Setup and Installation Instructions

### Prerequisites

To set up and run this project, ensure you have the following installed:
- **Java 17 or higher**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Maven**: [Download Maven](https://maven.apache.org/install.html)
- **MySQL** (or any other database): You need to have a running MySQL instance.
- **IDE**: Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) for development and testing.

### Installation Steps

1. **Clone the repository**

   ```bash
   git clone https://github.com/keerti1924/JobHive-Project-Job-Platform.git
   ```
2. **Create a MySQL Database**
- Create a new database named `jobhive` in your MySQL instance.

    ```bash
    CREATE DATABASE jobhive;
    ```

3. **Update Database Credentials**
- Open the `src/main/resources/application.properties` file and update the database connection settings with your MySQL credentials:

    ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/jobhive
    spring.datasource.username=root
    spring.datasource.password=your_password

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

4. **Build the Project**
- Navigate to the project root folder and run the Maven build command:

    ```bash
    mvn clean install
    ```
5. **Run the Application** 
- After building, run the Spring Boot application using the following command:

    ```bash
    mvn spring-boot:run
    ```

6. **Access the Application**
- Open a browser and navigate to:

    ```bash
    http://localhost:8080
    ```

## 📋 How to Use JobHive Platform

### Register or Login
- Visit the platform at `http://localhost:8080` or the deployed version.
- If you’re new, click on the **Sign Up** button to create an account by entering your email and setting a password.
- Existing users can click **Login** and enter their credentials to access the platform.

### Set Up Your Profile
- After logging in, head to the **Profile** section.
- Fill in your personal details like name, skills, education, and experience.
- You can also upload a profile picture and background image to personalize your profile.

### Search for Jobs
- Navigate to the **Jobs** section.
Use the search bar to find job postings that match your skills and interests.
- Filter jobs by location, industry, or other relevant criteria.

### Apply for Jobs
- Once you find a job that interests you, click on the **Apply** button.
- You can upload your resume to complete your application.

### Connect with Professionals
- Go to the **Network** section to search for professionals in your field.
- Send connection requests to build your professional network.
- Once connected, you can view their profiles and interact through messaging.

### Create or Interact with Posts
- On the **HomePage**, you can create posts to share updates or articles with your network.
- You can also **like**, **comment**, or share posts made by others.

### Send Messages
- Use the **Messaging** feature to send private messages to your connections.
- You will receive notifications when you have new messages.

### Receive Notifications
- Check the **Notifications** section to stay updated on job applications, new connections, and interactions with your posts.


## 👩‍💻 Project Structure

The project follows the **Model-View-Controller (MVC)** pattern and is organized into the following primary packages:

- `com.jobhive.controller`: Handles the user requests (HTTP endpoints) and maps them to the relevant services.
- `com.jobhive.model`: Defines the entities (database models) such as User, Job, Post, etc.
- `com.jobhive.repository`: Contains the data access logic using JPA repositories to interact with the database.
- `com.jobhive.service`: Implements the business logic of the application, e.g., creating jobs, handling user connections, etc.
- `resources/templates`: Thymeleaf templates for rendering dynamic HTML pages.


## 🤝 Contributing 

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](/issues).

## ⭐️ Show your support 

Give a ⭐️ if you like this project!


## 📝 License


MIT (c) [Keerti](https://github.com/keerti1924)
