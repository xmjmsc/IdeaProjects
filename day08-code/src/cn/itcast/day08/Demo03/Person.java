package cn.itcast.day08.Demo03;

public class Person {
    static {
        System.out.println("静态代码块执行！");//首次使用本类时，静态代码块执行唯一的一次
    }
    public Person(){
        System.out.println("构造方法执行");
    }

}

