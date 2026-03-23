import java.util.*;

class Level {
    int id;
    List<ParkingSpot> spots = new ArrayList<>();

    Map<Integer, Gate> gates = new HashMap<>();

    Level(int id) {
        this.id = id;
    }

    void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    void addGate(Gate gate) {
        gates.put(gate.id, gate);
    }

    Collection<Gate> getGates() {
        return gates.values();
    }
}