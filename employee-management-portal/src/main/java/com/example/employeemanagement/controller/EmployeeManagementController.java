package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.model.EmployeeManagementModel;
import com.example.employeemanagement.view.AddEmployeeDialog;
import com.example.employeemanagement.view.ChangePasswordDialog;
import com.example.employeemanagement.view.LoginView;
import com.example.employeemanagement.view.MainView;

import javax.swing.JOptionPane;

public class EmployeeManagementController {
    private final EmployeeManagementModel model;
    private LoginView loginView;
    private MainView mainView;

    public EmployeeManagementController(EmployeeManagementModel model) {
        this.model = model;
    }

    public void showLogin() {
        loginView = new LoginView();
        loginView.addLoginListener(event -> login());
        loginView.setVisible(true);
    }

    private void login() {
        char[] password = loginView.getPassword();
        boolean authenticated = model.authenticate(loginView.getUsername(), password);
        java.util.Arrays.fill(password, '\0');

        if (!authenticated) {
            loginView.showMessage("Invalid username or password.", "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        loginView.showMessage("Login successful. Welcome, admin!", "Login",
                JOptionPane.INFORMATION_MESSAGE);
        loginView.dispose();
        showMainWindow();
    }

    private void showMainWindow() {
        mainView = new MainView();
        mainView.addAddEmployeeListener(event -> showAddEmployeeDialog());
        mainView.addViewEmployeeListener(event -> viewEmployees());
        mainView.addChangePasswordListener(event -> showChangePasswordDialog());
        mainView.addLogoutListener(event -> logout());
        mainView.addExitApplicationListener(event -> System.exit(0));
        mainView.setVisible(true);
    }

    private void showAddEmployeeDialog() {
        AddEmployeeDialog dialog = new AddEmployeeDialog(mainView);
        dialog.addSaveListener(event -> {
            String employeeId = dialog.getEmployeeId();
            String name = dialog.getEmployeeName();
            String department = dialog.getDepartment();

            if (employeeId.isEmpty() || name.isEmpty() || department.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "All employee fields are required.",
                        "Invalid Employee", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!model.addEmployee(new Employee(employeeId, name, department))) {
                JOptionPane.showMessageDialog(dialog, "An employee with this ID already exists.",
                        "Duplicate Employee ID", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(dialog, "Employee added successfully.",
                    "Employee Added", JOptionPane.INFORMATION_MESSAGE);
            dialog.dispose();
        });
        dialog.setVisible(true);
    }

    private void viewEmployees() {
        if (model.getEmployees().isEmpty()) {
            JOptionPane.showMessageDialog(mainView, "No employees have been added yet.",
                    "View Employees", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder details = new StringBuilder();
        for (Employee employee : model.getEmployees()) {
            if (details.length() > 0) {
                details.append("\n\n");
            }
            details.append(employee);
        }
        JOptionPane.showMessageDialog(mainView, details.toString(),
                "Employees", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showChangePasswordDialog() {
        ChangePasswordDialog dialog = new ChangePasswordDialog(mainView);
        dialog.addChangeListener(event -> changePassword(dialog));
        dialog.setVisible(true);
    }

    private void changePassword(ChangePasswordDialog dialog) {
        char[] oldPassword = dialog.getOldPassword();
        char[] newPassword = dialog.getNewPassword();
        char[] confirmPassword = dialog.getConfirmPassword();

        if (newPassword.length == 0) {
            clearPasswords(oldPassword, newPassword, confirmPassword);
            JOptionPane.showMessageDialog(dialog, "New password cannot be empty.",
                    "Invalid Password", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!java.util.Arrays.equals(newPassword, confirmPassword)) {
            clearPasswords(oldPassword, newPassword, confirmPassword);
            JOptionPane.showMessageDialog(dialog, "New and confirm passwords do not match.",
                    "Password Mismatch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean changed = model.changePassword(oldPassword, newPassword);
        clearPasswords(oldPassword, newPassword, confirmPassword);
        if (!changed) {
            JOptionPane.showMessageDialog(dialog, "The old password is incorrect.",
                    "Password Change Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(dialog, "Password changed successfully.",
                "Password Changed", JOptionPane.INFORMATION_MESSAGE);
        dialog.dispose();
    }

    private void clearPasswords(char[]... passwords) {
        for (char[] password : passwords) {
            java.util.Arrays.fill(password, '\0');
        }
    }

    private void logout() {
        mainView.dispose();
        showLogin();
    }
}
