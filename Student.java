
public class Student {
    String name;
    int rollno;
    String department;

    Student(String name,int rollno,String department){
        this.name = name;
        this.rollno = rollno;
        this.department = department;
    }
    void displayDetails(){
        System.out.println("Student Name=" + name);
        System.out.println("Roll No.=" + rollno);
        System.out.println("Department =" + department);
    }
    public static void main(String[] args) {
        Student student1 = new Student("priyajit", 11, "CSE");
        student1.displayDetails();
    }
}

