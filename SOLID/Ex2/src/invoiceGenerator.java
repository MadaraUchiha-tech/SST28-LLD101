import java.util.*;
public class invoiceGenerator {
    static StringBuilder out = new StringBuilder();
    static String genInvId(int a){
        return "INV-" + a;
    }
    static void genhead(String invId){
        out.append("Invoice# ").append(invId).append("\n");
    }
    static void genbody(double subtotal, double taxPct, double tax, double discount, double total){
        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));
    }
    static void lineappend(List<OrderLine> lines, Map<String, MenuItem> menu){
        double subtotal=0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
    }
    static void footer(String invId, Database store){
        String printable = InvoiceFormatter.identityFormat(out.toString());
        System.out.print(printable);
        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
