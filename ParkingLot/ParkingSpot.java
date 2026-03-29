abstract class ParkingSpot {
    int spotNumber;
    Vehicle vehicle;
    double hourlyRate;

    public ParkingSpot(int spotNumber, double hourlyRate) {
        this.spotNumber = spotNumber;
        this.hourlyRate = hourlyRate;
    }

    boolean isAvailable() {
        return vehicle == null;
    }

    void occupy(Vehicle v) {
        this.vehicle = v;
    }

    void vacate() {
        this.vehicle = null;
    }

    abstract boolean canFitVehicle(Vehicle vehicle);
}

class SmallSpot extends ParkingSpot {
    public SmallSpot(int num) {
        super(num, 10);
    }

    boolean canFitVehicle(Vehicle v) {
        return v.type == VehicleType.BIKE;
    }
}

class MediumSpot extends ParkingSpot {
    public MediumSpot(int num) {
        super(num, 20);
    }

    boolean canFitVehicle(Vehicle v) {
        return v.type == VehicleType.CAR||v.type == VehicleType.BIKE;
    }
}

class LargeSpot extends ParkingSpot {
    public LargeSpot(int num) {
        super(num, 30);
    }

    boolean canFitVehicle(Vehicle v) {
        return true;
    }
}