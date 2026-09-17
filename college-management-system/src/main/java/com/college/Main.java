public class Main {
    public static void main(String[] args) {
        // Create a Student instance
        Student student = new Student("John Doe", 20, "S12345");
        
        // Create a Course instance
        Course course = new Course("Introduction to Programming", "CS101", 3);
        
        // Display Student information
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student ID: " + student.getStudentId());
        
        // Display Course information
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Course Code: " + course.getCourseCode());
        System.out.println("Credits: " + course.getCredits());
    }
}