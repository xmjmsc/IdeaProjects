package smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 完成零钱通的各个功能
 * */
public class SmallChangeSysOOP {
    //属性
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    //代表零钱
    String details = "-------零钱通明细--------";
    //收益
    String note = "";
    double money = 0; //收益入账
    double balance = 0; //余额
    Date data = null; //日期
    //日期格式化
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //各个功能函数


    public void mainMenu() {
        do {
            System.out.println("\n==============选择零钱通菜单==============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");
            System.out.println("请选择(1-4)：");
            key = scanner.next();
            //使用switch控制分支
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        } while (loop);
    }

    public void detail() {
        System.out.println(details);
    }

    public void income() {
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        if (money <= 0) {
            System.out.println("收益金额需要大于0");
            return;
        }
        balance += money;
        data = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(data) + "\t" + balance;
    }

    public void pay() {
        System.out.println("消费金额：");
        money = scanner.nextDouble();
        if (money <= 0 || money > balance) {
            System.out.println("消费金额应当在0-" + balance + "之间");
            return;
        }
        System.out.println("消费说明：");
        note = scanner.next();
        balance -= money;
        data = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(data) + "\t" + balance;
    }

    public void exit() {
        String choice = "";
        while (true) {
            System.out.println("你确定要退出吗？ y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        if ("y".equals(choice)) {
            loop = false;
        }
    }
}

