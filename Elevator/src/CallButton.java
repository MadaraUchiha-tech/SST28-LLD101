class CallButton implements IButton {
    private Direction direction;
    private int floorNumber;
    private ICallLiftStrategy strategy;

    public CallButton(Direction direction, int floorNumber, ICallLiftStrategy strategy) {
        this.direction = direction;
        this.floorNumber = floorNumber;
        this.strategy = strategy;
    }

    @Override
    public void press() {
        Lift lift = strategy.callLift(floorNumber, direction);

        lift.addRequest(new Request(floorNumber, direction));
    }
}