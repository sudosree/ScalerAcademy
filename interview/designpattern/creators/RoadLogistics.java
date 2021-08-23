package interview.designpattern.creators;

import interview.designpattern.products.Transport;
import interview.designpattern.products.Truck;

public class RoadLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}
