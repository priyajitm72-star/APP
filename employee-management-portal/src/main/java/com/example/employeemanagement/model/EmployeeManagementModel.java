package com.example.employeemanagement.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManagementModel {
    private static final String USERNAME = "admin";
    private String password = "admin123";
    private final List<Employee> employees = new ArrayList<>();

    public boolean authenticate(String username, char[] candidatePassword) {
        return USERNAME.equals(username) && passwordMatches(candidatePassword, password);
    }

    public boolean changePassword(char[] oldPassword, char[] newPassword) {
        if (!passwordMatches(oldPassword, password) || newPassword.length == 0) {
            return false;
        }

        password = new String(newPassword);
        return true;
    }

    public boolean addEmployee(Employee employee) {
        for (Employee existingEmployee : employees) {
            if (existingEmployee.getEmployeeId().equalsIgnoreCase(employee.getEmployeeId())) {
                return false;
            }
        }

        employees.add(employee);
        return true;
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(new ArrayList<>(employees));
    }

    private boolean passwordMatches(char[] candidatePassword, String expectedPassword) {
        if (candidatePassword.length != expectedPassword.length()) {
            return false;
        }

        for (int index = 0; index < candidatePassword.length; index++) {
            if (candidatePassword[index] != expectedPassword.charAt(index)) {
                return false;
            }
        }
        return true;
    }
}
