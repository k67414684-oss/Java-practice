package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task2 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task2: Product ---");
        Product monitor = new Product("A-101", "Монітор", 6499.50, 4);
        Product mouse = new Product("B-205", "Миша", -300, -5);
        Product keyboard = new Product("C-310", "Клавіатура", 1299.99, 10);
        System.out.println(monitor);
        System.out.println(mouse);
        System.out.println(keyboard);
    }

    static class Product {
        private String sku;
        private String title;
        private double price;
        private int stock;

        public Product(String sku, String title, double price, int stock) {
            this.sku = sku;
            this.title = title;
            setPrice(price);
            setStock(stock);
        }

        public String getSku() {
            return sku;
        }

        public String getTitle() {
            return title;
        }

        public double getPrice() {
            return price;
        }

        public final void setPrice(double price) {
            this.price = Math.max(0.0, price);
        }

        public int getStock() {
            return stock;
        }

        public final void setStock(int stock) {
            this.stock = Math.max(0, stock);
        }

        public double getTotalCost() {
            return price * stock;
        }

        @Override
        public String toString() {
            return String.format("[SKU: %s] %s | Ціна: %.2f грн | Залишок: %d шт. | Разом: %.2f грн",
                    sku, title, price, stock, getTotalCost());
        }
    }
}
