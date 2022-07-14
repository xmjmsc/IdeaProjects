package houserent.view;

import houserent.domain.House;
import houserent.service.HouseService;
import houserent.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService= new HouseService(10);
    //显示房屋列表
    public void listHouse() {
        System.out.println("房屋列表：");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                System.out.println(houses[i]);
            }
        }
    }

    public void mainMenu() {
        do {
            System.out.println("========房屋出租系统=====");
            System.out.println("\t\t\t1. 新增房源");
            System.out.println("\t\t\t2. 查找房源");
            System.out.println("\t\t\t3. 删除房屋信息");
            System.out.println("\t\t\t4. 修改房屋信息");
            System.out.println("\t\t\t5. 房屋列表");
            System.out.println("\t\t\t6. 退出");
            System.out.println("请输入你的选择（1-6）：");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    this.addHouse();
                    break;
                case '2':
                    this.findHouse();
                    break;
                case '3':
                    this.deleteHouse();
                    break;
                case '4':
                    this.updateHouse();
                    break;
                case '5':
                    this.listHouse();
                    break;
                case '6':
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }while (loop);
    }
}
