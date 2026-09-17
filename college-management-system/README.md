# College Management System

This project is a simple College Management System that allows for the management of student and course information. It is structured into separate packages for better organization and maintainability.

## Project Structure

```
college-management-system
├── src
│   └── main
│       └── java
│           └── com
│               └── college
│                   ├── Main.java
│                   ├── student
│                   │   └── Student.java
│                   └── course
│                       └── Course.java
├── README.md
└── pom.xml
```

## Features

- **Student Management**: The system allows for the creation and management of student records, including details such as name, age, and student ID.
- **Course Management**: The system manages course details, including course name, course code, and credits.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine.
- Maven installed for project management.

### Running the Application

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Use Maven to build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn exec:java -Dexec.mainClass="com.college.Main"
   ```

## Contributing

Feel free to submit issues or pull requests for any improvements or features you would like to see in this project.