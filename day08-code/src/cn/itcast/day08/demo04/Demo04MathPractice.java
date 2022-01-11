package cn.itcast.day08.demo04;

public class Demo04MathPractice {

    public static void main(String[] args) {
        int count = 0;

        double min = -10.8;
        double max = 5.9;

        for (int i = (int) min; i < max; i++) {
            int abs = Math.abs(i);
            if (abs < 2.1 || abs > 6) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("共有：" + count);

    }
}
