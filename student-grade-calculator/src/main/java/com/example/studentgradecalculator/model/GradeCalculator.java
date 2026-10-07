public class GradeCalculator {
    public int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculateAverageMarks(int[] marks) {
        if (marks.length == 0) {
            return 0;
        }
        int total = calculateTotalMarks(marks);
        return (double) total / marks.length;
    }

    public String determineGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}