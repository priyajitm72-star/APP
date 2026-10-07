package com.example.employeemanagement;

import com.example.employeemanagement.controller.EmployeeManagementController;
import com.example.employeemanagement.model.EmployeeManagementModel;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception exception) {
                System.err.println("Unable to apply the system look and feel: " + exception.getMessage());
            }

            EmployeeManagementModel model = new EmployeeManagementModel();
            new EmployeeManagementController(model).showLogin();
        });
    }
}
