public class student5 {
    String name;
    int age;
    student5(String name,int age){
        this.name = name;
        this.age = age;
    }
    void displayDetails(){
        System.out.println("Name="+ name);
        System.out.println("Age="+ age);
    }
    public static void main(String[] args) {
        student5 s1 = new student5("Priyajit", 19);
        student5 s2 = new student5("Aksh", 20);
        s1.displayDetails();
        s2.displayDetails();
    }

}
