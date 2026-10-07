package com.example.employeemanagement.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;

public class AddEmployeeDialog extends JDialog {
    private final JTextField employeeIdField = new JTextField(18);
    private final JTextField employeeNameField = new JTextField(18);
    private final JTextField departmentField = new JTextField(18);
    private final JButton saveButton = new JButton("Save");

    public AddEmployeeDialog(Window owner) {
        super(owner, "Add Employee", ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel fields = new JPanel(new GridLayout(3, 2, 8, 8));
        fields.add(new JLabel("Employee ID:"));
        fields.add(employeeIdField);
        fields.add(new JLabel("Employee Name:"));
        fields.add(employeeNameField);
        fields.add(new JLabel("Department:"));
        fields.add(departmentField);

        JPanel actions = new JPanel();
        actions.add(saveButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> dispose());
        actions.add(cancelButton);

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.add(fields, BorderLayout.CENTER);
        content.add(actions, BorderLayout.SOUTH);
        content.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        setContentPane(content);
        getRootPane().setDefaultButton(saveButton);
        pack();
        setLocationRelativeTo(owner);
    }

    public String getEmployeeId() {
        return employeeIdField.getText().trim();
    }

    public String getEmployeeName() {
        return employeeNameField.getText().trim();
    }

    public String getDepartment() {
        return departmentField.getText().trim();
    }

    public void addSaveListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }
}
