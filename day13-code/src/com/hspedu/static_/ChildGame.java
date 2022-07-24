package com.hspedu.static_;

public class ChildGame {

}


class Child {
    private String name;
    //静态变量可被共享
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println("Child " + name + " 加入了游戏");
    }

}