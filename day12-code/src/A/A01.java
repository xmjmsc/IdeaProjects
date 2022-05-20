package A;

public class A01 {

    public static void main(String[] args) {
        B01 b01 = new B01();
        double[] a = {1.5, 2.3, 3, 4.6, 5.9};
        //double[] a = {};

        Double a_1 = b01.max(a);
        if (a_1 != null) {// 1.5
            System.out.println("a的最大值=" + a_1);
        } else {
            System.out.println("a数组为空");
        }
    }
}
