package cn.itcast.day08.demo02;

public class Demo02StringGet {
    public static void main(String[] args) {
        int length = "cbfuybvfhb".length();
        System.out.println("字符串的长度是：" + length);

        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1.concat(str2);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        char ch = "Hello".charAt(1);
        System.out.println("在1号索引位置的字符是："+ch);

        String original = "HelloWorld";
        int index = original.indexOf("llo");
        System.out.println("第一次索引值是："+index);

    }

}
