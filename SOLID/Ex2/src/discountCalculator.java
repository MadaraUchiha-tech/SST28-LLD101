import java.util.*;
public class discountCalculator {
    double discount(String customerType, double subtotal, List<OrderLine> lines){
        return DiscountRules.discountAmount(customerType, subtotal, lines.size());
    }
}