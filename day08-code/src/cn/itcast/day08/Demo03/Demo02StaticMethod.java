package cn.itcast.day08.Demo03;

public class Demo02StaticMethod {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.method();
        //静态方法属于类，可通过对象名也可不通过对象名来调用
        obj.methodStatic();//不推荐
        MyClass.methodStatic();//推荐直接用类名称调用
        myMethod();
        Demo02StaticMethod.myMethod();//与上式完全等效

    }


    public static void myMethod(){
        System.out.println("自己的方法");
    }
}
