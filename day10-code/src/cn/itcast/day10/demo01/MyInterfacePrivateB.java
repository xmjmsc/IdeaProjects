package cn.itcast.day10.demo01;

public interface MyInterfacePrivateB {

    public static void methodDefault1(){
        System.out.println("静态方法");
        methodStaticCommon();

    }

    public static void methodDefault2(){
        System.out.println("静态方法2");
        methodStaticCommon();
    }

    private static void methodStaticCommon(){
        System.out.println("aa");
        System.out.println("bb");
        System.out.println("cc");
    }
}
