import java.util.*;

class LookScheduler implements IRequestScheduler {

    private PriorityQueue<Request> upQueue =
            new PriorityQueue<>(Comparator.comparingInt(r -> r.floor));

    private PriorityQueue<Request> downQueue =
            new PriorityQueue<>((a, b) -> b.floor - a.floor);

    @Override
    public void addRequest(Request request) {
        if (request.direction == Direction.UP) {
            upQueue.offer(request);
        } else {
            downQueue.offer(request);
        }
    }

    @Override
    public Request getNextRequest(int currentFloor, LiftState state) {

        if (state == LiftState.UP) {
            if (!upQueue.isEmpty()) return upQueue.poll();
            if (!downQueue.isEmpty()) return downQueue.poll();
        }

        if (state == LiftState.DOWN) {
            if (!downQueue.isEmpty()) return downQueue.poll();
            if (!upQueue.isEmpty()) return upQueue.poll();
        }

        if (!upQueue.isEmpty()) return upQueue.poll();
        if (!downQueue.isEmpty()) return downQueue.poll();

        return null;
    }
}