package com.hspedu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Stu A = new Stu("A");
        Stu B = new Stu("B");
        A.payFee(100);
        B.payFee(200);

        Stu.showFee();
    }
}

class Stu {
    private String name;
    //静态变量可被共享
    public static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    public static void payFee(double fee) {
        Stu.fee += fee;
    }

    public static void showFee() {
        System.out.println("总学费是：" + Stu.fee);
    }
}

