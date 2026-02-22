import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(),List.of(
                new singleRoom(),
                new doubleRoom(),
                new tripleRoom(),
                new deluxeRoom()
        ),List.of(
                new gymAddon(),
                new messAddon(),
                new laundryAddon()
        ));
        calc.process(req);
    }
}
