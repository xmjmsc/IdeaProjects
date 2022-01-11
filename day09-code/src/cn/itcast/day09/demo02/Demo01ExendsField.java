package cn.itcast.day09.demo02;

public class Demo01ExendsField {
    public static void main(String[] args) {
        Fu fu = new Fu();
        System.out.println(fu.numFu);
        Zi zi = new Zi();
        System.out.println(zi.numFu);
        System.out.println(zi.numZi);

        System.out.println(zi.num);

        zi.methodZi();

        zi.methodFu();//方法属于谁，则调用谁，没有则向上找

    }


}
