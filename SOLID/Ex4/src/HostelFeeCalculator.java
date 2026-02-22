import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<RoomInterface> rooms;
    private final List<addOnInterface> addons;

    public HostelFeeCalculator(FakeBookingRepo repo,List<RoomInterface> rooms, List<addOnInterface> addons) {
        this.repo = repo;
        this.rooms = rooms;
        this.addons = addons;
    }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double base=0.0;
        for(RoomInterface room:rooms){
            if(room.roomtype()==req.roomType) base=room.value();
        }

        double add = 0.0;
        for (AddOn a : req.addOns) {
            for(addOnInterface now:addons){
                if(a==now.getType()) add+=now.price();
            }
        }

        return new Money(base + add);
    }
}
