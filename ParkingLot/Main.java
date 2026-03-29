import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args){

        Level level1 = new Level(1);

        level1.addSpot(new SmallSpot(1));
        level1.addSpot(new SmallSpot(2));
        level1.addSpot(new MediumSpot(3));
        level1.addSpot(new MediumSpot(4));
        level1.addSpot(new LargeSpot(5));

        ParkingManager manager = new ParkingManager();
        manager.levels.add(level1);

        FareStrategy strategy = new DefaultFareStrategy();
        FareCalculator calculator = new FareCalculator(strategy);

        ParkingLot lot = new ParkingLot(manager, calculator);

        Vehicle car = new Bike("KA-01-1234");
        Vehicle bike = new Bike("KA-02-5678");
        Vehicle bus = new Bike("KA-03-9999");

        Ticket t1 = lot.create("T1", car, 1);
        Ticket t2 = lot.create("T2", bike, 1);
        Ticket t3 = lot.create("T3", bus, 1);

        lot.status();


        System.out.println("Exiting Vehicles");

        double fare1 = lot.exit(t1);
        System.out.println("Car Fare: " + fare1);

        double fare2 = lot.exit(t2);
        System.out.println("Bike Fare: " + fare2);

        double fare3 = lot.exit(t3);
        System.out.println("Bus Fare: " + fare3);

        lot.status();
    }
}