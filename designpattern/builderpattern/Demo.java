package designpattern.builderpattern;

import designpattern.builderpattern.builders.CarBuilder;
import designpattern.builderpattern.cars.Car;
import designpattern.builderpattern.director.Director;

public class Demo {

    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


    }
}
