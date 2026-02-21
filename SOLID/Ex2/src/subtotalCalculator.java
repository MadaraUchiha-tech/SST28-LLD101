import java.util.*;
public class subtotalCalculator {
    double subtotal(List<OrderLine> lines, Map<String, MenuItem> menu){
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }
        return subtotal;
    }
}
