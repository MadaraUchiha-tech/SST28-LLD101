import java.time.*;

class Ticket {
    String ticketId;
    Vehicle vehicle;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    ParkingSpot spot;
    int entryGate;

    public Ticket(String id, Vehicle v, LocalDateTime entryTime, ParkingSpot spot, int gate) {
        this.ticketId = id;
        this.vehicle = v;
        this.entryTime = entryTime;
        this.spot = spot;
        this.entryGate = gate;
    }

    long calculateParkingDuration() {
        if (exitTime == null) return 0;
        return Duration.between(entryTime, exitTime).toHours();
    }
}