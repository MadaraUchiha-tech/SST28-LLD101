import java.util.*;

class Lift {
    private int id;
    private int currentFloor;
    private LiftState state;
    private int weightLimit;

    private List<IButton> buttons;
    private IRequestScheduler scheduler;

    public Lift(int id, int currentFloor, int weightLimit, IRequestScheduler scheduler) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.weightLimit = weightLimit;
        this.state = LiftState.IDLE;
        this.scheduler = scheduler;
        this.buttons = new ArrayList<>();
    }

    public void addButton(IButton button) {
        buttons.add(button);
    }

    public void addRequest(Request request) {
        System.out.println("Lift " + id + " received request for floor " + request.floor);
        scheduler.addRequest(request);
    }

    public void processRequests() {
        Request request;

        while ((request = scheduler.getNextRequest(currentFloor, state)) != null) {
            moveToFloor(request.floor);
        }
    }

    public void moveToFloor(int floor) {
        System.out.println("Lift " + id + " moving from " + currentFloor + " to " + floor);

        if (floor > currentFloor) state = LiftState.UP;
        else if (floor < currentFloor) state = LiftState.DOWN;

        currentFloor = floor;
        state = LiftState.IDLE;

        System.out.println("Lift " + id + " reached floor " + currentFloor);
    }

    public int getCurrentFloor() { return currentFloor; }
    public LiftState getState() { return state; }
    public int getId() { return id; }
}
