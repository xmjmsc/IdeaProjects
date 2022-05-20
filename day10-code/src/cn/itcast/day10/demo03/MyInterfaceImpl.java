package cn.itcast.day10.demo03;

public class MyInterfaceImpl implements MyInterface{
    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }

    @Override
    public void methodCommon() {

    }

    @Override
    public void methoddefault() {
        MyInterface.super.methoddefault();
    }
}
