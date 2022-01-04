package cn.itcast.day08.demo02;

public class Demo01StringEquals {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";

        char[] charArray = {'H','e','l','l','o'};
        String str3 = new String(charArray);

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str3.equals("Hello"));
        System.out.println("Hello".equals(str1));//推荐写法

        String str4 = "hello";
        System.out.println(str4.equals(str1));
        String str5 = null;
        System.out.println("hello".equals(str5));//推荐：false
        //System.out.println(str5.equals("hello"));//不推荐：报错

        String strA = "Java";
        String strB = "java";
        System.out.println(strA.equals(strB));
        System.out.println(strA.equalsIgnoreCase(strB));

    }
}
