package cn.itcast.day08.demo01;

public class Demo01String {
    public static void main(String[] args) {
        String str1 = new String();
        System.out.println("第一个字符串："+ str1);

        char[] charArray = {'A','B','C'};
        String str2 = new String(charArray);
        System.out.println("第二个字符串："+ str2);

        byte[] byteArray = {97,98,'c'};
        String str3 = new String(byteArray);
        System.out.println("第三个字符串："+ str3);

        String str4 = "Hello";
        System.out.println("第四个字符串："+ str4);
    }
}
