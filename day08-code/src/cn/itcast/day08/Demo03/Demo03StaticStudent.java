package cn.itcast.day08.Demo03;

public class Demo03StaticStudent {
    public static void main(String[] args) {
        Student.room = "101教室";

        Student one = new Student("郭靖",20);
        //one.room = "101教室";
        System.out.println("姓名："+one.getName());
        System.out.println("年龄："+one.getAge());
        System.out.println("教室："+Student.room);

        Student two = new Student("黄蓉",19);
        //one.room = "101教室";
        System.out.println("姓名："+two.getName());
        System.out.println("年龄："+two.getAge());
        System.out.println("教室："+Student.room);




    }
}
