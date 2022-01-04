package cn.itcast.day08.Demo03;

public class Student {

    private int id;
    private String name;
    private int age;
    static String room;
    private static int idcounter = 0;



    public Student() {
        this.id = ++idcounter;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idcounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
