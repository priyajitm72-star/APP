
public class book {
    String title;
    double price;
    String author;

    book(String title,String author,double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    void displayDetails(){
        System.out.println("Title=" + title);
        System.out.println("Author's name=" + author);
        System.out.println("Price =" + price);
    }
    public static void main(String[] args) {
        book book1 = new book("APP", "Priyajit", 200);
        book1.displayDetails();
    }
}
