# Java Management Systems

This project consists of two main management systems: a College Management System and a Hospital Management System. Each system is organized into separate packages for better modularity and maintainability.

## Project Structure

```
java-management-systems
├── src
│   ├── student
│   │   └── Student.java          # Contains the Student class with details and methods for student management.
│   ├── course
│   │   └── Course.java           # Contains the Course class with details and methods for course management.
│   ├── doctor
│   │   └── Doctor.java           # Contains the Doctor class with details and methods for doctor management.
│   ├── patient
│   │   └── Patient.java          # Contains the Patient class with details and methods for patient management.
│   ├── Main7a.java               # Entry point for the College Management System.
│   ├── Main7b.java               # Entry point for the Hospital Management System.
│   ├── OnlineExamination7.java    # Implements an online examination system with concurrent activities.
│   ├── BankingActivities7.java     # Implements a banking application with concurrent activities.
│   └── TrafficManagement7.java     # Manages traffic conditions at different junctions using threads.
├── README.md                      # Documentation for the project.
└── .gitignore                     # Specifies files and directories to be ignored by version control.
```

## Usage

1. **College Management System**: 
   - The `Main7a.java` file serves as the entry point. It imports the `Student` and `Course` classes, creates instances, and displays their information.

2. **Hospital Management System**: 
   - The `Main7b.java` file serves as the entry point. It imports the `Doctor` and `Patient` classes, creates instances, assigns patients to doctors based on specialization, and displays the details of each patient along with their respective doctor. It also calculates and displays the total consultation fee collected by each doctor.

3. **Online Examination System**: 
   - The `OnlineExamination7.java` file implements the Runnable interface to manage concurrent activities such as displaying remaining time, auto-saving answers, and checking network connection.

4. **Banking Application**: 
   - The `BankingActivities7.java` file implements the Runnable interface for transaction processing, balance updating, and SMS notification.

5. **Traffic Management System**: 
   - The `TrafficManagement7.java` file extends the Thread class to monitor traffic conditions at three different junctions.

## Installation

To run the project, ensure you have Java Development Kit (JDK) installed. Clone the repository and navigate to the project directory. Compile the Java files and run the `Main7a.java` or `Main7b.java` to start the respective management system.

## Contributing

Feel free to fork the repository and submit pull requests for any improvements or bug fixes.