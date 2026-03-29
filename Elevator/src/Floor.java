import java.util.List;

class Floor {
    private int floorNumber;
    private List<Lift> lifts;
    private IButton upButton;
    private IButton downButton;

    public Floor(int floorNumber, List<Lift> lifts, ICallLiftStrategy strategy) {
        this.floorNumber = floorNumber;
        this.lifts = lifts;

        this.upButton = new CallButton(Direction.UP, floorNumber, strategy);
        this.downButton = new CallButton(Direction.DOWN, floorNumber, strategy);
    }

    public void pressUp() {
        upButton.press();
    }

    public void pressDown() {
        downButton.press();
    }
}
