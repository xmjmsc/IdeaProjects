package A;
//求某个数组最大值

public class B01 {
    public Double max(double[] a) {
        if (a != null && a.length > 0) {
            double max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            return max;
        } else return null;
    }
}
