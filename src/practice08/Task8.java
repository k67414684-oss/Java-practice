package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task8 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task8: InvoiceItem ---");
        InvoiceItem item = new InvoiceItem("Ноутбук Lenovo", 2, 25000.0, 10);

        System.out.println("Позиція чека: " + item);
        InvoiceItem bigDiscount = new InvoiceItem("Флешка 64GB", 3, 350.0, 80);
        System.out.println("Позиція чека: " + bigDiscount);
    }

    static class InvoiceItem {
        private String description;
        private int quantity;
        private double unitPrice;
        private double discountPercent;

        public InvoiceItem(String description, int quantity, double unitPrice, double discountPercent) {
            this.description = description;
            this.quantity = Math.max(1, quantity);
            this.unitPrice = Math.max(0.0, unitPrice);

            this.discountPercent = Math.min(50.0, Math.max(0.0, discountPercent));
        }

        public String getDescription() {
            return description;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getUnitPrice() {
            return unitPrice;
        }

        public double getDiscountPercent() {
            return discountPercent;
        }

        public double getFinalAmount() {
            double total = quantity * unitPrice;
            return total - total * discountPercent / 100.0;
        }

        @Override
        public String toString() {
            return String.format("%s x%d по %.2f грн (знижка %.1f%%) = %.2f грн",
                    description, quantity, unitPrice, discountPercent, getFinalAmount());
        }
    }
}
