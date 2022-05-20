package cn.itcast.day10.demo01;

public class MyInterfaceDefaultB implements MyInterfaceDefault{
    @Override
    public void methodAbs() {
        System.out.println("实现了抽象方法，BBB");


    }

    @Override
    public void methodDefault() {
        //MyInterfaceDefault.super.methodDefault();
        System.out.println("接口B覆盖重写了默认方法");
    }
}
