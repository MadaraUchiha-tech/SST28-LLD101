public class BallPen extends Pen {

    public BallPen(OpenCloseStrategy openCloseStrategy) {
        super(new BallRefillStrategy(), openCloseStrategy);
    }
}