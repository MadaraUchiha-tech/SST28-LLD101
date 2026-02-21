import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final Database store = new FileStore();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = invoiceGenerator.genInvId(++invoiceSeq);
        invoiceGenerator.genhead(invId);
        double subtotal = new subtotalCalculator().subtotal(lines,menu);
        invoiceGenerator.lineappend(lines,menu);
        double taxPct = TaxRules.taxPercent(customerType);
        double tax = new taxCalculator().tax(subtotal,taxPct);
        double discount=new discountCalculator().discount(customerType,subtotal,lines);
        double total= new totalCalculator().total(subtotal,tax,discount);
        invoiceGenerator.genbody(subtotal,taxPct,tax,discount,total);
        invoiceGenerator.footer(invId,store);
    }
}
