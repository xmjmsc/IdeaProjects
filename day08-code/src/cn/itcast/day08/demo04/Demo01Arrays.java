package cn.itcast.day08.demo04;

import java.util.Arrays;

public class Demo01Arrays {
    public static void main(String[] args) {
        int[] intArray = {10,20,30};
        String intStr = Arrays.toString(intArray);//参数数组变成字符串
        System.out.println(intStr);

        int[] array1 = {21,10,20,30,5,18,12};
        Arrays.sort(array1);//排序
        System.out.println(Arrays.toString(array1));

        String[] array2 = {"bbb","aaa","ccc"};
        Arrays.sort(array2);//排序
        System.out.println(Arrays.toString(array2));

    }
}
