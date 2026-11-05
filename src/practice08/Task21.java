package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task21 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task21: Parcel -> FragileParcel ---");
        Parcel parcel = new Parcel("NP-100200", 3.5);
        FragileParcel fragile = new FragileParcel("NP-100201", 3.5, true, 8000);
        System.out.println(parcel);
        System.out.println(fragile);
    }

    static class Parcel {
        private String trackingCode;
        private double weightKg;

        public Parcel(String trackingCode, double weightKg) {
            this.trackingCode = trackingCode;
            this.weightKg = Math.max(0.0, weightKg);
        }

        public String getTrackingCode() {
            return trackingCode;
        }

        public double getWeightKg() {
            return weightKg;
        }

        public double calculateShippingCost() {
            return 50.0 + weightKg * 12.0;
        }

        @Override
        public String toString() {
            return String.format("Parcel{code='%s', weight=%.2f кг, shipping=%.2f грн}",
                    trackingCode, weightKg, calculateShippingCost());
        }
    }

    static class FragileParcel extends Parcel {
        private boolean requiresWoodenBox;
        private double insuranceValue;

        public FragileParcel(String trackingCode, double weightKg, boolean requiresWoodenBox, double insuranceValue) {
            super(trackingCode, weightKg);
            this.requiresWoodenBox = requiresWoodenBox;
            this.insuranceValue = Math.max(0.0, insuranceValue);
        }

        @Override
        public double calculateShippingCost() {
            double cost = super.calculateShippingCost();
            cost += insuranceValue * 0.015;
            if (requiresWoodenBox) {
                cost += 120.0;
            }
            return cost;
        }

        @Override
        public String toString() {
            return String.format("FragileParcel{code='%s', weight=%.2f кг, insurance=%.2f, дерев'яна коробка=%s, ДО СПЛАТИ=%.2f грн}",
                    getTrackingCode(), getWeightKg(), insuranceValue, requiresWoodenBox ? "так" : "ні",
                    calculateShippingCost());
        }
    }
}
