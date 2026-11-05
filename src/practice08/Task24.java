package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task24 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task24: Coffee -> LatteWithAddons ---");
        Coffee espresso = new Coffee("темне", 60, 55);
        LatteWithAddons latte = new LatteWithAddons("середнє", 300, 85, "вівсяне", 2);
        System.out.println(espresso);
        System.out.println(latte);
    }

    static class Coffee {
        private String roastType;
        private int volumeMl;
        private double basePrice;

        public Coffee(String roastType, int volumeMl, double basePrice) {
            this.roastType = roastType;
            this.volumeMl = Math.max(0, volumeMl);
            this.basePrice = Math.max(0.0, basePrice);
        }

        public String getRoastType() {
            return roastType;
        }

        public int getVolumeMl() {
            return volumeMl;
        }

        public double getBasePrice() {
            return basePrice;
        }

        public double calculateCalories() {
            return volumeMl * 0.02;
        }

        public double calculatePrice() {
            return basePrice;
        }

        @Override
        public String toString() {
            return String.format("Coffee{roast='%s', %d мл, %.0f ккал, %.2f грн}",
                    roastType, volumeMl, calculateCalories(), calculatePrice());
        }
    }

    static class LatteWithAddons extends Coffee {
        private String milkType;
        private int syrupPumps;

        public LatteWithAddons(String roastType, int volumeMl, double basePrice, String milkType, int syrupPumps) {
            super(roastType, volumeMl, basePrice);
            this.milkType = milkType;
            this.syrupPumps = Math.max(0, syrupPumps);
        }

        private boolean isPlantMilk() {
            return !milkType.equalsIgnoreCase("звичайне");
        }

        @Override
        public double calculateCalories() {
            double milkKcalPerMl = isPlantMilk() ? 0.4 : 0.6;
            double milkCalories = getVolumeMl() * 0.5 * milkKcalPerMl;
            return super.calculateCalories() + milkCalories + syrupPumps * 20.0;
        }

        @Override
        public double calculatePrice() {
            double price = super.calculatePrice();
            if (isPlantMilk()) {
                price += 20.0;
            }
            return price + syrupPumps * 12.0;
        }

        @Override
        public String toString() {
            return String.format("========== ЧЕК КАВ'ЯРНІ ==========%n"
                            + "Напій:   Латте (%s обсмаження)%n"
                            + "Об'єм:   %d мл%n"
                            + "Молоко:  %s%n"
                            + "Сироп:   %d порц. x 12.00 грн%n"
                            + "Калорії: %.0f ккал%n"
                            + "РАЗОМ:   %.2f грн%n"
                            + "==================================",
                    getRoastType(), getVolumeMl(), milkType, syrupPumps, calculateCalories(), calculatePrice());
        }
    }
}
