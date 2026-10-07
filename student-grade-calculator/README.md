# Student Grade Calculator

This project is a Student Grade Calculator application built using Java Swing, following the Model-View-Controller (MVC) architecture. It allows users to input student details, calculate grades based on marks, and display the results in a user-friendly interface.

## Project Structure

```
student-grade-calculator
├── src
│   └── main
│       └── java
│           └── com
│               └── example
│                   └── studentgradecalculator
│                       ├── Main.java
│                       ├── controller
│                       │   └── GradeController.java
│                       ├── model
│                       │   ├── Student.java
│                       │   └── GradeCalculator.java
│                       └── view
│                           └── GradeCalculatorView.java
└── README.md
```

## Features

- Input student name and marks.
- Calculate total marks and average.
- Determine the grade based on average marks.
- User-friendly graphical interface using Swing.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code)

### Running the Application

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```
   cd student-grade-calculator
   ```

3. Compile the Java files:
   ```
   javac src/main/java/com/example/studentgradecalculator/*.java
   ```

4. Run the application:
   ```
   java -cp src/main/java com.example.studentgradecalculator.Main
   ```

## Usage

1. Enter the student's name and marks in the provided fields.
2. Click the "Calculate" button to compute the total marks, average, and grade.
3. The results will be displayed in the application window.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue for any suggestions or improvements.

## License

This project is licensed under the MIT License. See the LICENSE file for details.