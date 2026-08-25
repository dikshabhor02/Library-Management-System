# 📚 Library Management System

A web-based **Library Management System** built with **Java, Spring Boot, Spring Data JPA, Hibernate, MySQL and Thymeleaf**.

The application provides basic library operations such as user registration and login, adding books, viewing the available book list, and updating book information.

---

## 📌 Project Overview

The goal of this project is to build a simple library management application using Spring Boot and a relational database.

The application follows a layered backend structure with:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL Database
```

The frontend pages are rendered using **Thymeleaf**.

---

## ✨ Features

### 👤 User Management

* User registration
* User login
* Username-based user identification
* Unique username validation at database level

### 📖 Book Management

* Add a new book
* View all books
* View/update book details
* Store book information in MySQL

### 🌐 Web Interface

* Login page
* Registration page
* Home page
* Add Book page
* Book List page
* Update Book page

---

## 🛠️ Tech Stack

### Backend

![Java](https://img.shields.io/badge/Java%2021-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)

![Spring Boot](https://img.shields.io/badge/Spring%20Boot%204.1.1-6DB33F?style=for-the-badge\&logo=springboot\&logoColor=white)

![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge\&logo=spring\&logoColor=white)

![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge\&logo=hibernate\&logoColor=white)

### Frontend

![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge\&logo=thymeleaf\&logoColor=white)

![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge\&logo=html5\&logoColor=white)

![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge\&logo=css3\&logoColor=white)

### Database

![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge\&logo=mysql\&logoColor=white)

### Tools

![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge\&logo=apachemaven\&logoColor=white)

![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge\&logo=git\&logoColor=white)

---

## 🏗️ Application Architecture

The application uses a layered architecture.

```text
                    Browser
                       │
                       ▼
                LibraryController
                       │
             ┌─────────┴─────────┐
             ▼                   ▼
        UserService          BookRepository
             │                   │
             ▼                   ▼
       UserRepository       JPA / Hibernate
             │                   │
             └─────────┬─────────┘
                       ▼
                    MySQL
```

### Controller Layer

`LibraryController` handles the application's web requests including login, registration, book creation, book listing and book updates.

### Service Layer

`UserService` contains user-related operations such as registration and login processing.

### Repository Layer

Spring Data JPA repositories provide database access for users and books.

### Entity Layer

The application contains two main entities:

* `User`
* `Book`

---

## 📂 Project Structure

```text
Library-Management-System/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/Library/Management/System/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   └── LibraryController.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   ├── Book.java
│   │   │       │   └── User.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   ├── BookRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── UserService.java
│   │   │       │
│   │   │       └── LibraryManagementSystemApplication.java
│   │   │
│   │   └── resources/
│   │       └── templates/
│   │           ├── login.html
│   │           ├── register.html
│   │           ├── home.html
│   │           ├── add.html
│   │           ├── list.html
│   │           └── update.html
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## 🔗 Application Routes

| Method | Route          | Purpose                   |
| ------ | -------------- | ------------------------- |
| `GET`  | `/`            | Display login page        |
| `POST` | `/login`       | Process user login        |
| `GET`  | `/register`    | Display registration page |
| `POST` | `/register`    | Register a new user       |
| `GET`  | `/home`        | Display home page         |
| `GET`  | `/add`         | Display add-book page     |
| `POST` | `/add`         | Add a new book            |
| `GET`  | `/list`        | Display all books         |
| `GET`  | `/update/{id}` | Display book update page  |
| `POST` | `/update`      | Update book information   |

These routes are implemented in the application's `LibraryController`.

---

## 📖 Book Entity

The `Book` entity is mapped using JPA and contains:

```text
Book
 ├── id
 ├── name
 ├── author
 └── description
```

The `id` is generated automatically using the database identity strategy.

---

## 👤 User Entity

The `User` entity contains:

```text
User
 ├── id
 ├── username
 ├── password
 ├── fullName
 └── email
```

The username is configured as unique in the database using JPA's `@Column(unique = true)`.

---

## 🗄️ Database

The project uses **MySQL** with **Spring Data JPA/Hibernate** for persistence.

The main entities are:

```text
User
Book
```

JPA handles the mapping between Java entity classes and database tables.

---

## ⚙️ How to Run

### Prerequisites

Install the following:

* Java 21
* Maven
* MySQL
* Git

### 1. Clone the Repository

```bash
git clone https://github.com/dikshabhor02/Library-Management-System.git
```

### 2. Open the Project

Open the inner project directory:

```text
Library-Management-System/Library-Management-System
```

You can open it using IntelliJ IDEA, Eclipse or another Java IDE.

### 3. Configure MySQL

Create a MySQL database and configure the database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

> Never commit real database passwords or other sensitive credentials to GitHub.

### 4. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run:

```text
LibraryManagementSystemApplication.java
```

from your IDE.

### 5. Open the Application

After the application starts, open:

```text
http://localhost:8080/
```

---

## 🔄 Application Flow

```text
                    START
                      │
                      ▼
                 Login Page
                      │
              ┌───────┴───────┐
              │               │
           Login           Register
              │               │
              ▼               ▼
          Validate          Save User
              │               │
              └───────┬───────┘
                      ▼
                    Home
                      │
                      ▼
                 Add Book
                      │
                      ▼
                Save Book
                      │
                      ▼
                 Book List
                      │
                      ▼
               Update Book
```

---

## 📚 What I Learned

This project helped me strengthen my understanding of:

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* MySQL
* Thymeleaf
* MVC architecture
* CRUD operations
* Entity and Repository concepts
* Form handling in Spring MVC
* HTTP GET and POST requests
* Maven project structure
* Database integration

---

## 🚀 Future Improvements

The project can be extended with:

* [ ] Spring Security authentication
* [ ] BCrypt password hashing
* [ ] Role-based access control
* [ ] JWT authentication
* [ ] Book deletion
* [ ] Book search
* [ ] Book issue/return functionality
* [ ] Due-date tracking
* [ ] Fine calculation
* [ ] User dashboard
* [ ] Pagination and sorting
* [ ] Validation using Bean Validation
* [ ] Global exception handling
* [ ] Unit and integration tests
* [ ] Swagger/OpenAPI documentation

---

## 👩‍💻 Author

### Diksha Bhor

**Java Backend Developer | Spring Boot | REST APIs | MySQL**

💻 GitHub: [github.com/dikshabhor02](https://github.com/dikshabhor02)

💼 LinkedIn: [linkedin.com/in/diksha-bhor](https://www.linkedin.com/in/diksha-bhor)

---

⭐ If you find this project useful, consider giving it a star!
