import java.util.List;

class IdleFirstStrategy implements ICallLiftStrategy {

    private List<Lift> lifts;

    public IdleFirstStrategy(List<Lift> lifts) {
        this.lifts = lifts;
    }

    @Override
    public Lift callLift(int floor, Direction direction) {

        Lift bestIdleLift = null;
        int minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            if (lift.getState() == LiftState.IDLE) {
                int distance = Math.abs(lift.getCurrentFloor() - floor);

                if (distance < minDistance) {
                    minDistance = distance;
                    bestIdleLift = lift;
                }
            }
        }

        if (bestIdleLift != null) {
            System.out.println("Assigned IDLE Lift " + bestIdleLift.getId());
            return bestIdleLift;
        }

        Lift bestMovingLift = null;
        minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            int distance = Math.abs(lift.getCurrentFloor() - floor);

            if (distance < minDistance) {
                minDistance = distance;
                bestMovingLift = lift;
            }
        }

        System.out.println("No idle lift found, assigned moving Lift " + bestMovingLift.getId());
        return bestMovingLift;
    }
}