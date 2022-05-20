package cn.itcast.day10.demo01;

public interface MyInterfaceDefault {

    public abstract void methodAbs();
    //public abstract void methodAbs2();

    public default void methodDefault(){
        System.out.println("这是新添加的默认方法");
    }
}
