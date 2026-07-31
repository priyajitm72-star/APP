public class student1 {
    String name;
    int rollno;

    student1(String name,int rollno){
        this.name = name;
        this.rollno = rollno;
    }
    public static void main(String[] args) {
        student1 student = new student1("Priyajit", 11);

        System.out.println("Student Name: " + student.name);
        System.out.println("Roll Number: " + student.rollno);

    }
}