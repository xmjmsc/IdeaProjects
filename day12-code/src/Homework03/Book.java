package Homework03;

public class Book {
    private double price;
    private String name;

    public Book() {
    }

    public Book(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updatePrice(){
        if (this.price > 150){
            this.price = 150;
        }else if (this.price > 100){
            this.price = 100;
        }
    }
}
