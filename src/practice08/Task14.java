package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task14 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task14: Gadget -> Smartphone (3 конструктори) ---");
        Smartphone full = new Smartphone("Samsung", 24999.0, 256, true);
        Smartphone middle = new Smartphone("Xiaomi", 12999.0, 128);
        Smartphone minimal = new Smartphone("Nokia");
        System.out.println(full);
        System.out.println(middle);
        System.out.println(minimal);
    }

    static class Gadget {
        private String brand;
        private double price;

        public Gadget(String brand, double price) {
            this.brand = brand;
            this.price = Math.max(0.0, price);
        }

        public String getBrand() {
            return brand;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("Gadget{brand='%s', price=%.2f грн}", brand, price);
        }
    }

    static class Smartphone extends Gadget {
        private int memoryGb;
        private boolean has5G;

        public Smartphone(String brand, double price, int memoryGb, boolean has5G) {
            super(brand, price);
            this.memoryGb = memoryGb > 0 ? memoryGb : 64;
            this.has5G = has5G;
        }

        public Smartphone(String brand, double price, int memoryGb) {
            this(brand, price, memoryGb, true);
        }

        public Smartphone(String brand) {
            this(brand, 9999.0, 128, false);
        }

        public int getMemoryGb() {
            return memoryGb;
        }

        public boolean isHas5G() {
            return has5G;
        }

        @Override
        public String toString() {
            return "Smartphone{" + super.toString() + ", memory=" + memoryGb + " ГБ, 5G=" + (has5G ? "так" : "ні") + "}";
        }
    }
}
