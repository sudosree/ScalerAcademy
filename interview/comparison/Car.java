package interview.comparison;

public class Car implements Vehicle, Alarm {

    private String brand;

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }

    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Alarm.super.turnAlarmOff();
    }

    public String printCar() {
        return Alarm.print();
    }
}
