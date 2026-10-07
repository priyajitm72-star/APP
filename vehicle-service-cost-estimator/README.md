# Vehicle Service Cost Estimator

## Overview
The Vehicle Service Cost Estimator is a Java Swing application designed to help users estimate the service cost of their vehicles. Users can input their vehicle registration number, select the type of vehicle (Two Wheeler or Car), and choose from a list of available services. The application calculates the total cost based on the selected services.

## Features
- Input for Vehicle Registration Number
- Selection of Vehicle Type (Two Wheeler or Car)
- Checkboxes for selecting services:
  - General Service – ₹1,000
  - Oil Change – ₹800
  - Brake Service – ₹1,200
  - Battery Check – ₹500
- Calculation of total service cost upon user request

## Project Structure
```
vehicle-service-cost-estimator
├── src
│   └── main
│       └── java
│           └── com
│               └── example
│                   ├── Main.java
│                   ├── controller
│                   │   └── ServiceController.java
│                   ├── model
│                   │   └── ServiceCostModel.java
│                   └── view
│                       └── ServiceView.java
└── README.md
```

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- An IDE or text editor for Java development

### Running the Application
1. Clone the repository or download the project files.
2. Open the project in your preferred IDE.
3. Navigate to the `Main.java` file located in `src/main/java/com/example/`.
4. Run the `Main` class to start the application.

### Usage
- Enter the vehicle registration number in the provided text field.
- Select the type of vehicle using the radio buttons.
- Check the boxes for the services you wish to include in the estimate.
- Click the "Calculate Cost" button to view the total service cost.

## License
This project is licensed under the MIT License - see the LICENSE file for details.