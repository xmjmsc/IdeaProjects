package Homework03;

public class A03 {
    public static void main(String[] args) {
        Book book = new Book();
        double price = 130;
        book.setPrice(price);  //
        book.updatePrice();
        System.out.println(book.getPrice());
    }
}
