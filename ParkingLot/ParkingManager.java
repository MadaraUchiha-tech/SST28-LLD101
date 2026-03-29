import java.util.*;
import java.time.*;

class ParkingManager {
    Map<VehicleType, List<ParkingSpot>> availableSpots = new HashMap<>();
    Map<Vehicle, ParkingSpot> vehicleToSpot = new HashMap<>();
    List<Level> levels = new ArrayList<>();

    ParkingSpot findSpotForVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            for (ParkingSpot spot : level.spots) {
                if (spot.isAvailable() && spot.canFitVehicle(vehicle)) {
                    return spot;
                }
            }
        }
        return null;
    }

    ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findSpotForVehicle(vehicle);
        if (spot != null) {
            spot.occupy(vehicle);
            vehicleToSpot.put(vehicle, spot);
        }
        return spot;
    }

    void unparkVehicle(Vehicle vehicle) {
        ParkingSpot spot = vehicleToSpot.get(vehicle);
        if (spot != null) {
            spot.vacate();
            vehicleToSpot.remove(vehicle);
        }
    }
}