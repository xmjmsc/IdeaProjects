package cn.itcast.day10.demo03;

public interface MyInterfaceB {
    public abstract void methodB();
    public abstract void methodCommon();
    public default void methoddefault(){
        System.out.println("BBB");
    }

}
