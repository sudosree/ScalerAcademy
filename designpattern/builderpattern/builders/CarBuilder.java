package designpattern.builderpattern.builders;

import designpattern.builderpattern.cars.Car;
import designpattern.builderpattern.cars.CarType;
import designpattern.builderpattern.components.Engine;
import designpattern.builderpattern.components.GPSNavigator;
import designpattern.builderpattern.components.Transmission;
import designpattern.builderpattern.components.TripComputer;

/*
* Concrete builder class for creating different types
* of car based on the steps defined in the builder interface
* */
public class CarBuilder implements Builder {
    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(carType, seats, engine, transmission,
                        tripComputer, gpsNavigator);
    }
}
