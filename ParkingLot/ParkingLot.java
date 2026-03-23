import java.time.*;

class ParkingLot {

    ParkingManager manager;
    FareCalculator calculator;

    ParkingLot(ParkingManager manager, FareCalculator calculator) {
        this.manager = manager;
        this.calculator = calculator;
    }

    Ticket park(Vehicle vehicle, LocalDateTime entryTime, int gateId) {
        return manager.park(vehicle, entryTime, gateId);
    }

    double exit(Ticket ticket, LocalDateTime exitTime) {
        ticket.exitTime = exitTime;

        manager.unpark(ticket);

        return calculator.calculate(ticket);
    }

    void status() {
        System.out.println(manager.getStatus());
    }
}