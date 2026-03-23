public abstract class Pen {

    RefillStrategy refillStrategy;
    OpenCloseStrategy openCloseStrategy;

    public Pen(RefillStrategy refillStrategy, OpenCloseStrategy openCloseStrategy) {
        this.refillStrategy = refillStrategy;
        this.openCloseStrategy = openCloseStrategy;
    }

    public void start() {
        openCloseStrategy.open();
    }

    public void write(String message) {
        System.out.println(message);
    }

    public void close() {
        openCloseStrategy.close();
    }

    public void refill() {
        refillStrategy.refill();
    }
}