import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ParkingManager manager = new ParkingManager();

        Level l1 = new Level(1);

        ParkingSpot s1 = new ParkingSpot(1, SlotType.SMALL);
        ParkingSpot s2 = new ParkingSpot(2, SlotType.MEDIUM);
        ParkingSpot s3 = new ParkingSpot(3, SlotType.LARGE);

        l1.addSpot(s1);
        l1.addSpot(s2);
        l1.addSpot(s3);

        manager.allSpots.put(1, s1);
        manager.allSpots.put(2, s2);
        manager.allSpots.put(3, s3);

        Level l2 = new Level(2);

        ParkingSpot s4 = new ParkingSpot(4, SlotType.SMALL);
        ParkingSpot s5 = new ParkingSpot(5, SlotType.LARGE);

        l2.addSpot(s4);
        l2.addSpot(s5);

        manager.allSpots.put(4, s4);
        manager.allSpots.put(5, s5);

        Gate gate1 = new Gate(1, GateType.ENTRY);
        gate1.addDistance(1, 5);
        gate1.addDistance(2, 3);
        gate1.addDistance(3, 1);
        gate1.addDistance(4, 7);
        gate1.addDistance(5, 6);

        manager.gates.put(1, gate1);

        l1.addGate(gate1);
        l2.addGate(gate1);

        manager.levels.add(l1);
        manager.levels.add(l2);

        Map<VehicleType, Double> rates = new HashMap<>();
        rates.put(VehicleType.BIKE, 10.0);
        rates.put(VehicleType.CAR, 20.0);
        rates.put(VehicleType.BUS, 30.0);

        ParkingLot lot = new ParkingLot(manager, new FareCalculator(rates));

        Vehicle bike = new Bike("KA-01");

        Ticket t = lot.park(bike, LocalDateTime.now(), 1);

        lot.status();

        double bill = lot.exit(t, LocalDateTime.now().plusHours(3));

        System.out.println("Bill = " + bill);
    }
}