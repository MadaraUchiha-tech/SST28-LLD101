class ParkingSpot {
    int id;
    SlotType type;
    boolean occupied = false;

    ParkingSpot(int id, SlotType type) {
        this.id = id;
        this.type = type;
    }

    boolean isAvailable() {
        return !occupied;
    }

    void park() {
        occupied = true;
    }

    void free() {
        occupied = false;
    }
}