package houserent.service;

import houserent.domain.House;

/*
 * 储存数据，表示当前用户
 * 业务层，提供对数据的增删改查
 * 响应HouseView的请求
 */
public class HouseService {
    private House[] houses;
    private int houseNums = 1;//多少房屋信息
    private int idCounter = 1;//当前房屋信息的索引

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "张三", "12345678901", "北京市海淀区", 1000, "可出租");

    }

    /**
     * 功能：添加新对象
     *
     * @param newHouse 新的房屋信息
     * @return boolean
     */
    public boolean add(House newHouse) {
        if (houseNums >= houses.length) {
            return false;
        }
        houses[houseNums++] = newHouse;
        //houseNums++;
        newHouse.setId(++idCounter);
        return true;
    }

    /**
     * 功能：删除房屋
     *
     * @param delId 房屋id
     * @return boolean
     */
    public boolean delete(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {//要删除房屋id，是数组下标为i的元素
                index = i;
            }
        }
        if (index == -1) {//没找到要删除的房屋
            return false;
        }
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNums - 1] = null;
        return true;
    }

    /**
     * 功能：查找房屋
     *
     * @param findById 房屋id
     * @return House或者null
     */
    public House findById(int findById) {
        for (int i = 0; i < houseNums; i++) {
            if (findById == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }


    /**
     * 功能：显示房屋列表
     *
     * @param
     * @return House
     */
    public House[] list() {
        return houses;
    }
}

