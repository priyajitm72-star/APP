import student.Student;
import course.Course;

public class Main7a {
    public static void main(String[] args) {
        // Create instances of Student
        Student student1 = new Student("S001", "Alice", 20);
        Student student2 = new Student("S002", "Bob", 22);

        // Create instances of Course
        Course course1 = new Course("C001", "Mathematics", 3);
        Course course2 = new Course("C002", "Computer Science", 4);

        // Display student information
        System.out.println("Student Information:");
        student1.display();
        student2.display();

        // Display course information
        System.out.println("\nCourse Information:");
        course1.display();
        course2.display();
    }
}