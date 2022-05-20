package cn.itcast.day09.demo06;

public class Demo01Phone {
    public static void main(String[] args) {
        Phone phone =new Phone();
        phone.call();
        phone.send();
        phone.show();

        NewPhone newphone =new NewPhone();
        newphone.call();
        newphone.send();
        newphone.show();

    }
}
