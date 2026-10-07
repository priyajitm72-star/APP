import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GradeCalculatorView extends JFrame {
    private JTextField nameField;
    private JTextField marksField;
    private JTextArea resultArea;
    private JButton calculateButton;
    private JButton clearButton;

    public GradeCalculatorView() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Student Name:");
        nameField = new JTextField(20);
        
        JLabel marksLabel = new JLabel("Marks (comma separated):");
        marksField = new JTextField(20);
        
        calculateButton = new JButton("Calculate Grade");
        clearButton = new JButton("Clear");
        
        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        
        add(nameLabel);
        add(nameField);
        add(marksLabel);
        add(marksField);
        add(calculateButton);
        add(clearButton);
        add(new JScrollPane(resultArea));

        setVisible(true);
    }

    public String getStudentName() {
        return nameField.getText();
    }

    public String getMarks() {
        return marksField.getText();
    }

    public void setResult(String result) {
        resultArea.setText(result);
    }

    public void addCalculateListener(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }
}