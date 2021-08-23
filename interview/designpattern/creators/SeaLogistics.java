package interview.designpattern.creators;

import interview.designpattern.products.Ship;
import interview.designpattern.products.Transport;

public class SeaLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}
