package cn.itcast.day10.demo01;

//public class 实现类名称 implements 接口名称

public class Demo01Interface {
    public static void main(String[] args) {
        MyInterfaceAbstractImpl impl = new MyInterfaceAbstractImpl();
        impl.methodAbs1();
        impl.methodAbs2();
    }
}
