import java.time.*;
import java.util.*;

class ParkingLot {

    ParkingManager manager;
    FareCalculator fareCalculator;

    public ParkingLot(ParkingManager manager, FareCalculator calculator) {
        this.manager = manager;
        this.fareCalculator = calculator;
    }

    Ticket create(String ticketId, Vehicle vehicle, int entryGate) {
        ParkingSpot spot = manager.parkVehicle(vehicle);
        if (spot == null) {
            System.out.println("No spot available");
            return null;
        }

        return new Ticket(ticketId, vehicle, LocalDateTime.now(), spot, entryGate);
    }

    double exit(Ticket ticket) {
        ticket.exitTime = LocalDateTime.now();
        manager.unparkVehicle(ticket.vehicle);
        return fareCalculator.calculateFare(ticket);
    }

    void status() {
        System.out.println("Parking Status:");
        for (Level level : manager.levels) {
            for (ParkingSpot spot : level.spots) {
                System.out.println("Spot " + spot.spotNumber +
                        " -> " + (spot.isAvailable() ? "Free" : "Occupied"));
            }
        }
    }
}