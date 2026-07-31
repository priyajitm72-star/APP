public class rectangle {
    double length;
    double breath;
    rectangle(double length,double breath){
        this.length = length;
        this.breath = breath;
    }
    void calculateArea(){
        double area = length*breath;
        System.out.println("Area of rectangle="+ area);
    }
    public static void main(String[] args) {
        rectangle r = new rectangle(20, 10);
        r.calculateArea();
    }
}

