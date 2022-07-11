package houserent.view;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    public static void mainMenu() {
        do {
            System.out.println("========房屋出租系统=====");
            System.out.println("1. 查询房屋信息");
            System.out.println("2. 添加房屋信息");
            System.out.println("3. 修改房屋信息");
            System.out.println("4. 删除房屋信息");
            System.out.println("5. 退出");
        }while (loop);
    }
}
