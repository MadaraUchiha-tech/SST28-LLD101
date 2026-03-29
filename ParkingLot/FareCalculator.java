class FareCalculator {
    FareStrategy strategy;

    public FareCalculator(FareStrategy strategy) {
        this.strategy = strategy;
    }

    double calculateFare(Ticket ticket) {
        return strategy.calculateFare(ticket, ticket.spot.hourlyRate);
    }
}