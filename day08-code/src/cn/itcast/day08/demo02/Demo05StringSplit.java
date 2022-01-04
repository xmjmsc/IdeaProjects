package cn.itcast.day08.demo02;
/*
split的参数是一个正则表达式，如果.
需用\\.
 */
public class Demo05StringSplit {
    public static void main(String[] args) {
        String str1 = "aaa,bbb,ccc,d";
        String[] array1 = str1.split(",");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        String str2 = "aaa.bbb.ccc.d";
        String[] array2 = str1.split("\\.");//需要用\\.
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }
}