interface FareStrategy {
    double calculateFare(Ticket ticket, double hourlyRate);
}

class DefaultFareStrategy implements FareStrategy {
    public double calculateFare(Ticket ticket, double rate) {
        long hours = Math.max(1, ticket.calculateParkingDuration());
        return hours * rate;
    }
}

class PeakHoursStrategy implements FareStrategy {
    public double calculateFare(Ticket ticket, double rate) {
        long hours = Math.max(1, ticket.calculateParkingDuration());
        return hours * rate * 1.5;
    }
}