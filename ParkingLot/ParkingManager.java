import java.util.*;
import java.time.*;

class ParkingManager {

    List<Level> levels = new ArrayList<>();

    Map<Integer, Gate> gates = new HashMap<>();

    Map<Integer, ParkingSpot> allSpots = new HashMap<>();

    Map<String, Ticket> activeTickets = new HashMap<>();

    List<SlotType> getAllowedSlots(VehicleType type) {
        if (type == VehicleType.BIKE)
            return List.of(SlotType.SMALL, SlotType.MEDIUM, SlotType.LARGE);

        if (type == VehicleType.CAR)
            return List.of(SlotType.MEDIUM, SlotType.LARGE);

        return List.of(SlotType.LARGE);
    }

    ParkingSpot findNearestSlot(Vehicle vehicle, Gate gate) {
        List<SlotType> allowed = getAllowedSlots(vehicle.type);

        Set<Integer> validSlotIds = new HashSet<>();

        for (Level level : levels) {
            if (level.gates.containsKey(gate.id)) {
                for (ParkingSpot spot : level.spots) {
                    validSlotIds.add(spot.id);
                }
            }
        }

        return gate.distanceMap.entrySet().stream()
                .filter(e -> validSlotIds.contains(e.getKey()))
                .sorted(Map.Entry.comparingByValue())
                .map(e -> allSpots.get(e.getKey()))
                .filter(Objects::nonNull)
                .filter(s -> s.isAvailable() && allowed.contains(s.type))
                .findFirst()
                .orElse(null);
    }

    Ticket park(Vehicle vehicle, LocalDateTime entryTime, int gateId) {
        Gate gate = gates.get(gateId);
        if (gate == null) return null;

        ParkingSpot spot = findNearestSlot(vehicle, gate);
        if (spot == null) return null;

        spot.park();

        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle, spot, gate, entryTime);

        activeTickets.put(ticketId, ticket);
        return ticket;
    }

    void unpark(Ticket ticket) {
        ticket.spot.free();
        activeTickets.remove(ticket.id);
    }

    Map<SlotType, Long> getStatus() {
        Map<SlotType, Long> map = new HashMap<>();

        for (SlotType type : SlotType.values()) {
            long count = allSpots.values().stream()
                    .filter(s -> s.type == type && s.isAvailable())
                    .count();
            map.put(type, count);
        }
        return map;
    }
}