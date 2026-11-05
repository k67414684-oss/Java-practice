package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Task36 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task36: WarehouseItem -> DiscountedWarehouseItem ---");
        double[] prices = {410, 395, 420, 405};
        WarehouseItem item = new WarehouseItem("Миша Logitech", 20, prices);
        DiscountedWarehouseItem sale = new DiscountedWarehouseItem("Миша Logitech", 20, prices, "старий склад", 30);
        System.out.println(item);
        System.out.println(sale);
    }

    static class WarehouseItem {
        private String name;
        private int quantity;
        private double[] priceHistory;

        public WarehouseItem(String name, int quantity, double[] priceHistory) {
            this.name = name;
            this.quantity = Math.max(0, quantity);
            this.priceHistory = (priceHistory == null) ? new double[0] : Arrays.copyOf(priceHistory, priceHistory.length);
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getAveragePurchasePrice() {
            if (priceHistory.length == 0) {
                return 0.0;
            }
            double sum = 0;
            for (double p : priceHistory) {
                sum += p;
            }
            return sum / priceHistory.length;
        }

        @Override
        public String toString() {
            return String.format("WarehouseItem{name='%s', qty=%d, ціни=%s, середня закупівля=%.2f}",
                    name, quantity, Arrays.toString(priceHistory), getAveragePurchasePrice());
        }
    }

    static class DiscountedWarehouseItem extends WarehouseItem {
        private String markdownReason;
        private double discountPercent;

        public DiscountedWarehouseItem(String name, int quantity, double[] priceHistory,
                                       String markdownReason, double discountPercent) {
            super(name, quantity, priceHistory);
            this.markdownReason = markdownReason;
            this.discountPercent = Math.min(100.0, Math.max(0.0, discountPercent));
        }

        public double getClearancePrice() {
            return super.getAveragePurchasePrice() * (1 - discountPercent / 100.0);
        }

        public double getClearanceTotal() {
            return getClearancePrice() * getQuantity();
        }

        @Override
        public String toString() {
            return String.format("DiscountedWarehouseItem{%s, причина уцінки='%s', знижка=%.0f%%, ціна розпродажу=%.2f, разом=%.2f}",
                    super.toString(), markdownReason, discountPercent, getClearancePrice(), getClearanceTotal());
        }
    }
}
