package cn.itcast.day08.demo04;

import java.util.Arrays;

public class Demo02Practise {
    public static void main(String[] args) {

        String str = "duyerwbgf84873h233e2enub2138r82";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);

        }


    }



}
