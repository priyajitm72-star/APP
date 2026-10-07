package com.example.employeemanagement.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;

public class ChangePasswordDialog extends JDialog {
    private final JPasswordField oldPasswordField = new JPasswordField(18);
    private final JPasswordField newPasswordField = new JPasswordField(18);
    private final JPasswordField confirmPasswordField = new JPasswordField(18);
    private final JButton changeButton = new JButton("Change Password");

    public ChangePasswordDialog(Window owner) {
        super(owner, "Change Password", ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel fields = new JPanel(new GridLayout(3, 2, 8, 8));
        fields.add(new JLabel("Old Password:"));
        fields.add(oldPasswordField);
        fields.add(new JLabel("New Password:"));
        fields.add(newPasswordField);
        fields.add(new JLabel("Confirm Password:"));
        fields.add(confirmPasswordField);

        JPanel actions = new JPanel();
        actions.add(changeButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> dispose());
        actions.add(cancelButton);

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.add(fields, BorderLayout.CENTER);
        content.add(actions, BorderLayout.SOUTH);
        content.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        setContentPane(content);
        getRootPane().setDefaultButton(changeButton);
        pack();
        setLocationRelativeTo(owner);
    }

    public char[] getOldPassword() {
        return oldPasswordField.getPassword();
    }

    public char[] getNewPassword() {
        return newPasswordField.getPassword();
    }

    public char[] getConfirmPassword() {
        return confirmPasswordField.getPassword();
    }

    public void addChangeListener(ActionListener listener) {
        changeButton.addActionListener(listener);
    }
}
