package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task18 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task18: ShoppingOrder ---");
        ShoppingOrder order = new ShoppingOrder();
        order.addItem("Хліб", 28.50, 2);
        order.addItem("Молоко", 42.00, 1);
        order.addItem("Хліб", 28.50, 1);
        order.addItem("Сир", 210.90, 1);
        System.out.println(order);
    }

    static class OrderItem {
        private final String productName;
        private final double unitPrice;
        private int quantity;

        public OrderItem(String productName, double unitPrice, int quantity) {
            this.productName = productName;
            this.unitPrice = Math.max(0.0, unitPrice);
            this.quantity = Math.max(1, quantity);
        }

        public String getProductName() {
            return productName;
        }

        public void addQuantity(int extra) {
            if (extra > 0) {
                quantity += extra;
            }
        }

        public double getItemTotal() {
            return unitPrice * quantity;
        }

        @Override
        public String toString() {
            return String.format("%-10s %6.2f x %d = %8.2f", productName, unitPrice, quantity, getItemTotal());
        }
    }

    static class ShoppingOrder {
        private final OrderItem[] items = new OrderItem[10];
        private int itemCount;

        public void addItem(String name, double price, int qty) {
            for (int i = 0; i < itemCount; i++) {
                if (items[i].getProductName().equalsIgnoreCase(name)) {
                    items[i].addQuantity(qty);
                    return;
                }
            }
            if (itemCount < items.length) {
                items[itemCount++] = new OrderItem(name, price, qty);
            }
        }

        public double calculateGrandTotal() {
            double total = 0;
            for (int i = 0; i < itemCount; i++) {
                total += items[i].getItemTotal();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("========== ЧЕК ==========\n");
            for (int i = 0; i < itemCount; i++) {
                sb.append(items[i]).append("\n");
            }
            sb.append("-------------------------\n");
            sb.append(String.format("РАЗОМ: %.2f грн%n", calculateGrandTotal()));
            sb.append("=========================");
            return sb.toString();
        }
    }
}
