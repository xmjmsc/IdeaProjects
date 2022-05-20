package cn.itcast.day10.demo01;

public interface MyInterfacePrivateA {

    public default void methodDefault1(){
        System.out.println("默认方法1");
        methodCommon();

    }

    public default void methodDefault2(){
        System.out.println("默认方法2");
        methodCommon();
    }

    private void methodCommon(){
        System.out.println("aa");
        System.out.println("bb");
        System.out.println("cc");
    }
}
