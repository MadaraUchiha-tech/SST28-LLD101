public class InkPen extends Pen {

    public InkPen(OpenCloseStrategy openCloseStrategy) {
        super(new InkRefillStrategy(), openCloseStrategy);
    }
}