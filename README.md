# Project Overview

Each folder in this repository contains a different Java project. The first project demonstrates how to connect a Java application to a PostgreSQL database using JDBC, while the second project demonstrates a simple Jakarta EE servlet.


# 1. JDBC Implementation with PostgreSQL

## Project Overview
This project demonstrates how to connect a Java application to a PostgreSQL database using JDBC. It allows fetching and displaying data from the `users` table.

## Requirements
- Java 8 or later
- PostgreSQL (Version 16 recommended)
- pgAdmin (optional, for database management)
- PostgreSQL JDBC Driver (download from: https://jdbc.postgresql.org/)

## Setup Instructions

### 1. Install PostgreSQL
- Download and install PostgreSQL from [official site](https://www.postgresql.org/download/).
- During installation, set up a **username** and **password** (default user is `postgres`).
- Open `pgAdmin` and create a new database named `AD-dev1`.  

### 2. Create the `users` Table
Open `pgAdmin`, go to the **Query Tool**, and run the following SQL script:
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO users (name, email) VALUES
('Name1', 'x@email.com'),
('Name2', 'y@email.com');
```

### 3. Configure JDBC Connection
Edit `Main.java` and update the following variables with your PostgreSQL credentials:
```java
String url = "jdbc:postgresql://localhost:5432/AD-dev1"; // Replace with your PostgreSQL database name
String user = "your_username";  // Replace with your PostgreSQL username
String password = "your_password";  // Replace with your PostgreSQL password
```

### 4. Compile and Run the Program
1. Download the PostgreSQL JDBC Driver (`postgresql-42.7.1.jar`) from [here](https://jdbc.postgresql.org/).
2. Place the `.jar` file in your project directory.
3. Compile the Java program:
   ```sh
   javac -cp .;postgresql-42.7.1.jar Main.java
   ```
4. Run the program:
   ```sh
   java -cp .;postgresql-42.7.1.jar org.example.Main
   ```

### 5. Expected Output
```
Connected to the PostgreSQL database successfully!
id   name    email
----------------------
1    Name1   x@email.com
2    Name2     y@email.com
```

## Additional Notes
- If you encounter issues, ensure PostgreSQL is running and your credentials are correct.
- If `mvn` (Maven) is not installed, you can run the project without it by manually downloading dependencies.


# 2. Servlet Java Implementation

## Project Overview

In this project, I created a simple Jakarta EE servlet using Maven to demonstrate basic server-side functionality. The servlet, named `HelloServlet`, handles HTTP GET requests and returns a simple HTML response.

## Setup Instructions

### 1. Create a Jakarta EE Project

- Set up a Jakarta EE project with Maven in an IDE like IntelliJ or Eclipse.

### 2. Implement the Servlet

- Create the `HelloServlet` class, extending `HttpServlet`.
- Use the `@WebServlet` annotation to map the servlet to a URL.
- Implement the `doGet` method to return a basic HTML response.

### 3. Deploy and Run the Servlet

- Configure the `pom.xml` to include the necessary Jakarta EE dependencies.
- Deploy the servlet to a server like Apache Tomcat.
- Access the servlet via a web browser using the specified URL.

## Expected Output

When accessing the servlet via the browser, you should see a simple HTML page that says "Bonjour Yara Cham".


**Author:** _Yara Cham_
**Date:** _February 2025_

