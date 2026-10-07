package com.example.employeemanagement.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private final JMenuItem addEmployeeItem = new JMenuItem("Add Employee");
    private final JMenuItem viewEmployeeItem = new JMenuItem("View Employee");
    private final JMenuItem changePasswordItem = new JMenuItem("Change Password");
    private final JMenuItem logoutItem = new JMenuItem("Logout");
    private final JMenuItem exitApplicationItem = new JMenuItem("Exit Application");

    public MainView() {
        setTitle("Employee Management Portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu employeeMenu = new JMenu("Employee");
        employeeMenu.add(addEmployeeItem);
        employeeMenu.add(viewEmployeeItem);
        JMenu toolsMenu = new JMenu("Tools");
        toolsMenu.add(changePasswordItem);
        JMenu exitMenu = new JMenu("Exit");
        exitMenu.add(logoutItem);
        exitMenu.add(exitApplicationItem);
        menuBar.add(employeeMenu);
        menuBar.add(toolsMenu);
        menuBar.add(exitMenu);
        setJMenuBar(menuBar);

        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.add(new JLabel("Welcome to the Employee Management Portal", JLabel.CENTER),
                BorderLayout.CENTER);
        setContentPane(welcomePanel);
    }

    public void addAddEmployeeListener(ActionListener listener) {
        addEmployeeItem.addActionListener(listener);
    }

    public void addViewEmployeeListener(ActionListener listener) {
        viewEmployeeItem.addActionListener(listener);
    }

    public void addChangePasswordListener(ActionListener listener) {
        changePasswordItem.addActionListener(listener);
    }

    public void addLogoutListener(ActionListener listener) {
        logoutItem.addActionListener(listener);
    }

    public void addExitApplicationListener(ActionListener listener) {
        exitApplicationItem.addActionListener(listener);
    }
}
