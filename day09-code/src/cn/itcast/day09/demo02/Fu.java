package cn.itcast.day09.demo02;

public class Fu {

    int numFu = 10;
    int num = 100;

    public void methodFu() {
        System.out.println(num);//使用本类中的num，不会向下找
    }
}
