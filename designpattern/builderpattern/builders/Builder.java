package designpattern.builderpattern.builders;

import designpattern.builderpattern.cars.CarType;
import designpattern.builderpattern.components.Engine;
import designpattern.builderpattern.components.GPSNavigator;
import designpattern.builderpattern.components.Transmission;
import designpattern.builderpattern.components.TripComputer;

/*
* This Builder interface defines all the possible ways
* to build a product
* */
public interface Builder {

    void setCarType(CarType carType);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
