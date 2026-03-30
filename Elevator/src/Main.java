import java.util.*;

public class Main {
    public static void main(String[] args) {

        IRequestScheduler scheduler = new LookScheduler();

        Lift lift1 = new Lift(1, 0, 500, scheduler);
        Lift lift2 = new Lift(2, 6, 500, scheduler);

        List<Lift> lifts = Arrays.asList(lift1, lift2);

        // Add buttons inside lift
        lift1.addButton(new GoToButton(lift1, 4));
        lift1.addButton(new AlarmButton());

        lift2.addButton(new GoToButton(lift2, 2));
        lift2.addButton(new AlarmButton());

        // Strategy
        ICallLiftStrategy strategy = new NearestLiftStrategy(lifts);

        // Floors
        Floor floor2 = new Floor(2, lifts, strategy);
        Floor floor5 = new Floor(5, lifts, strategy);
        Floor floor3 = new Floor(3, lifts, strategy);

        // Simulate multiple requests
        floor2.pressUp();
        floor5.pressDown();
        floor3.pressUp();

        System.out.println("\n--- Processing Requests ---\n");

        lift1.processRequests();
        lift2.processRequests();
    }
}