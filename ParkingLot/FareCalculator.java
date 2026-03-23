import java.util.*;

class FareCalculator {

    Map<VehicleType, Double> rates;

    FareCalculator(Map<VehicleType, Double> rates) {
        this.rates = rates;
    }

    double calculate(Ticket ticket) {
        long hours = ticket.getDurationHours();
        double rate = rates.get(ticket.vehicle.type);
        return hours * rate;
    }
}