package designpattern.builderpattern;

import designpattern.builderpattern.house.House;

public class HouseDemo {

    public static void main(String[] args) {
        House smallHouse = new House.Builder(4, 1, 4, 2, 1).build();
        System.out.println(smallHouse.getWalls());
        System.out.println(smallHouse.getFloors());
        System.out.println(smallHouse.getDoors());
        System.out.println(smallHouse.getWindows());
        System.out.println(smallHouse.getRoofs());
    }
}
