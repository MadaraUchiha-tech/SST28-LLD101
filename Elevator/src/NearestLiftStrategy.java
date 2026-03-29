import java.util.List;

class NearestLiftStrategy implements ICallLiftStrategy {
    private List<Lift> lifts;

    public NearestLiftStrategy(List<Lift> lifts) {
        this.lifts = lifts;
    }

    @Override
    public Lift callLift(int floor, Direction direction) {
        Lift bestLift = null;
        int minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            int distance = Math.abs(lift.getCurrentFloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                bestLift = lift;
            }
        }

        System.out.println("Assigned Lift " + bestLift.getId());
        return bestLift;
    }
}
