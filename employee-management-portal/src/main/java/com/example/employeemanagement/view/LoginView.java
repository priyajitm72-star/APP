package com.example.employeemanagement.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private final JTextField usernameField = new JTextField(18);
    private final JPasswordField passwordField = new JPasswordField(18);
    private final JButton loginButton = new JButton("Login");

    public LoginView() {
        setTitle("Employee Management Portal - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel fields = new JPanel(new GridLayout(2, 2, 8, 8));
        fields.add(new JLabel("Username:"));
        fields.add(usernameField);
        fields.add(new JLabel("Password:"));
        fields.add(passwordField);

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.add(fields, BorderLayout.CENTER);
        content.add(loginButton, BorderLayout.SOUTH);
        content.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        setContentPane(content);
        getRootPane().setDefaultButton(loginButton);
        pack();
        setLocationRelativeTo(null);
    }

    public String getUsername() {
        return usernameField.getText().trim();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }
}
