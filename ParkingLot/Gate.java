import java.util.*;

class Gate {
    int id;
    GateType type;

    Map<Integer, Integer> distanceMap = new HashMap<>();

    Gate(int id, GateType type) {
        this.id = id;
        this.type = type;
    }

    void addDistance(int slotId, int distance) {
        distanceMap.put(slotId, distance);
    }
}