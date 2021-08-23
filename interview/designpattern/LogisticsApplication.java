package interview.designpattern;

import interview.designpattern.creators.Logistics;
import interview.designpattern.creators.RoadLogistics;

public class LogisticsApplication {

    public static void main(String[] args) {
        Logistics logistics = new RoadLogistics();
        logistics.planDelivery();
    }
}
