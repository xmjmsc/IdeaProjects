package cn.itcast.day08.Demo03;

public class MyClass {

    int num;//成员变量
    static int numStatic;//静态变量

    public void method(){
        System.out.println("这是一个成员方法");
        System.out.println(num);
        System.out.println(numStatic);
        //成员方法可以访问静态或非静态变量
    }
    public static void methodStatic(){
        System.out.println("这是一个静态方法");
        //System.out.println(num);
        System.out.println(numStatic);
        //静态方法不可以访问非静态变量，也不可使用this
    }
}
