public class ClickStrategy implements OpenCloseStrategy {
    public void open() {
        System.out.println("Click to open pen");
    }

    public void close() {
        System.out.println("Click to close pen");
    }
}