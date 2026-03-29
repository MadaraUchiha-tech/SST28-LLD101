import java.util.*;

class Level {
    int floorNumber;
    List<ParkingSpot> spots = new ArrayList<>();
    List<Gate> gates = new ArrayList<>();

    public Level(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }
    public void addGate(Gate gate) {
        gates.add(gate);
    }
}