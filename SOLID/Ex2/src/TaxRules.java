public class TaxRules {
    public static TaxInterface forCustomer(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) {
            return new StudentTax();
        }
        if ("staff".equalsIgnoreCase(customerType)) {
            return new StaffTax();
        }
        return new NormalTax();
    }
    public static double taxPercent(String customerType) {
        TaxInterface policy =forCustomer(customerType);
        return policy.tax();
    }
}
