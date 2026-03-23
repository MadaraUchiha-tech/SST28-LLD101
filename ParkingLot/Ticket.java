import java.time.*;

class Ticket {
    String id;
    Vehicle vehicle;
    ParkingSpot spot;
    Gate entryGate;
    LocalDateTime entryTime;
    LocalDateTime exitTime;

    Ticket(String id, Vehicle v, ParkingSpot s, Gate gate, LocalDateTime entryTime) {
        this.id = id;
        this.vehicle = v;
        this.spot = s;
        this.entryGate = gate;
        this.entryTime = entryTime;
    }

    long getDurationHours() {
        if (exitTime == null) return 0;
        return Math.max(1, Duration.between(entryTime, exitTime).toHours());
    }
}