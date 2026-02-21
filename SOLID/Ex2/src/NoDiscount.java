public class NoDiscount implements DiscountInterface{
    @Override
    public double value(double subtotal, int distinctLines){
        return 0.0;
    }
}