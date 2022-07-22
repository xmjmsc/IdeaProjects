package houserent.view;

import houserent.domain.House;
import houserent.service.HouseService;
import houserent.utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);
    //显示房屋列表


    public void addHouse() {
        System.out.println("请输入房主姓名：");
        String name = Utility.readString(8);
        System.out.println("请输入房主电话：");
        String phone = Utility.readString(11);
        System.out.println("请输入房主地址：");
        String address = Utility.readString(10);
        System.out.println("请输入房主月租：");
        int rent = Utility.readInt();
        System.out.println("请输入房主状态：");
        String state = Utility.readString(3);
        House newHouse = new House(0, name, phone, address, rent, state);

        if (houseService.add(newHouse)) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

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

    public void deleteHouse() {
        System.out.println("请输入要删除的房屋编号(-1退出)：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("放弃删除！");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.delete(delId)) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        } else {
            System.out.println("放弃删除！");
        }
        /*House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null && houses[i].getId() == delId) {
                houses[i] = null;
                System.out.println("删除成功！");
                return;
            }
        }
        System.out.println("删除失败！");*/
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        } else {
            System.out.println("放弃退出！");
        }
    }

    public void findHouse() {
        System.out.println("请输入要查找的房屋编号(-1退出)：");
        int findId = Utility.readInt();
        if (findId == -1) {
            System.out.println("放弃查找！");
            return;
        }
        House houses = houseService.findById(findId);
        if (houses != null) {
            System.out.println(houses);
        } else {
            System.out.println("查找id不存在！");
        }
    }

    public void updateHouse() {
        System.out.print("请输入要修改的房屋编号(-1退出)：");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.print("放弃修改！");
            return;
        }
        House houses = houseService.findById(updateId);
        if (houses == null) {
            System.out.print("修改id不存在！");
            return;
        }
        System.out.print("请输入房主姓名(" + houses.getName() + ")：");
        String name = Utility.readString(8, "");//不输入信息则默认
        if (!"".equals(name)) {
            houses.setName(name);
        }
        System.out.print("请输入房主电话(" + houses.getPhone() + ")：");
        String phone = Utility.readString(11, "");//不输入信息则默认
        if (!"".equals(phone)) {
            houses.setPhone(phone);
        }
        System.out.print("请输入房主地址(" + houses.getAddress() + ")：");
        String address = Utility.readString(10, "");//不输入信息则默认
        if (!"".equals(address)) {
            houses.setAddress(address);
        }
        System.out.print("请输入房主月租(" + houses.getRent() + ")：");
        int rent = Utility.readInt(-1);//不输入信息则默认
        if (rent != -1) {
            houses.setRent(rent);
        }
        System.out.print("请输入房主状态(" + houses.getState() + ")：");
        String state = Utility.readString(3, "");//不输入信息则默认
        if (!"".equals(state)) {
            houses.setState(state);
        }
        System.out.println("修改成功！");
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
        } while (loop);
    }
}
