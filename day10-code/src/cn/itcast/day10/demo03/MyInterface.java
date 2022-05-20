package cn.itcast.day10.demo03;

public interface MyInterface extends MyInterfaceA,MyInterfaceB{
    public abstract void methodA();

    @Override
    default void methoddefault() {

    }

}
