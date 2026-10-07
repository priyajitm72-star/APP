package com.example.studentgradecalculator.controller;

import com.example.studentgradecalculator.model.GradeCalculator;
import com.example.studentgradecalculator.model.Student;
import com.example.studentgradecalculator.view.GradeCalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeController {
    private GradeCalculator model;
    private GradeCalculatorView view;

    public GradeController(GradeCalculator model, GradeCalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = view.getStudentName();
            int marks = view.getStudentMarks();

            Student student = new Student(name, marks);
            model.addStudent(student);

            double average = model.calculateAverage();
            String grade = model.determineGrade(average);

            view.setAverage(average);
            view.setGrade(grade);
        }
    }
}