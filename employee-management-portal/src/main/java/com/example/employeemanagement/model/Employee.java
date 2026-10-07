package com.example.employeemanagement.model;

public class Employee {
    private final String employeeId;
    private final String name;
    private final String department;

    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId
                + "\nName: " + name
                + "\nDepartment: " + department;
    }
}
