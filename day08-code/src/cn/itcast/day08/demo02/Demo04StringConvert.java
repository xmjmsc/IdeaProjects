package cn.itcast.day08.demo02;

import java.nio.charset.StandardCharsets;

public class Demo04StringConvert {
    public static void main(String[] args) {
        //将字符串转化为数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars.length);

        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);


        String str1 = "How do you do?";
            String str2 = str1.replace("o", "*");//替换词可以是中文
            System.out.println(str1);
            System.out.println(str2);
        }
    }
}
