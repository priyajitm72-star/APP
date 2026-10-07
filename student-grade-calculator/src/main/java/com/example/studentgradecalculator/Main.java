package com.example.studentgradecalculator;

import javax.swing.SwingUtilities;
import com.example.studentgradecalculator.view.GradeCalculatorView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeCalculatorView view = new GradeCalculatorView();
            view.setVisible(true);
        });
    }
}