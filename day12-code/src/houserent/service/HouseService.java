package houserent.service;

import houserent.domain.House;

public class HouseService {
    private House[] houses;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "张三", "12345678901", "北京市海淀区", 1000, "可出租");
    }
    public House[] list() {
        return houses;
    }
}

