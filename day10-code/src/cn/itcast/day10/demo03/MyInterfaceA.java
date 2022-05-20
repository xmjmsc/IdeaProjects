package cn.itcast.day10.demo03;

public interface MyInterfaceA {
    public abstract void methodA();
    public abstract void methodCommon();
    public default void methoddefault(){
        System.out.println("AAA");
    }


}
