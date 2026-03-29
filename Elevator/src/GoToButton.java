class GoToButton implements IButton {
    private Lift lift;
    private int targetFloor;

    public GoToButton(Lift lift, int targetFloor) {
        this.lift = lift;
        this.targetFloor = targetFloor;
    }

    @Override
    public void press() {
        System.out.println("GoToButton pressed for floor " + targetFloor);
        lift.addRequest(new Request(targetFloor, Direction.UP));
    }
}