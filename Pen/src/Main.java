public class Main {
    public static void main(String[] args) {

        Pen pen = PenFactory.getPen("gel", "cap");

        pen.start();
        pen.write("nice to meet you");
        pen.refill();
        pen.close();
    }
}