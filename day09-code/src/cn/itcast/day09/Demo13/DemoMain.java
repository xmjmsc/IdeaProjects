package cn.itcast.day09.Demo13;

public class DemoMain {
    public static void main(String[] args) {

        Dog2Ha ha = new Dog2Ha();
        ha.sleep();
        ha.eat();
        System.out.println("============");
        DogGolden golden = new DogGolden();
        golden.sleep();
        golden.eat();
    }
}
