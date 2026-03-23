public class PenFactory {

    public static Pen getPen(String type, String openType) {

        OpenCloseStrategy openStrategy;

        if (openType.equalsIgnoreCase("click")) {
            openStrategy = new ClickStrategy();
        } else {
            openStrategy = new UncapStrategy();
        }

        switch (type.toLowerCase()) {
            case "ink":
                return new InkPen(openStrategy);

            case "gel":
                return new GelPen(openStrategy);

            case "ball":
                return new BallPen(openStrategy);

            default:
                throw new IllegalArgumentException("Invalid pen type");
        }
    }
}