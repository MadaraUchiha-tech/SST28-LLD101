public class GelPen extends Pen {

    public GelPen(OpenCloseStrategy openCloseStrategy) {
        super(new GelRefillStrategy(), openCloseStrategy);
    }
}