package Homework02;

public class A01 {
    public static void main(String[] args) {
        Findlist findlist = new Findlist();
        int[] lista = {1,23,6,56,6,5,65,5,9};
        int a =23;
        System.out.println("该元素的索引为"+findlist.find(lista,a));
    }
}
