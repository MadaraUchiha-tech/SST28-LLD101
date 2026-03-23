public class UncapStrategy implements OpenCloseStrategy {
    public void open() {
        System.out.println("Uncapping the pen");
    }

    public void close() {
        System.out.println("Capping the pen");
    }
}