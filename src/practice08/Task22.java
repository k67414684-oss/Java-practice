package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task22 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task22: Appliance -> EcoHeater ---");
        Appliance appliance = new Appliance("Чайник Philips", 2000);
        EcoHeater ecoOn = new EcoHeater("Обігрівач Ardesto", 1500, true);
        EcoHeater ecoOff = new EcoHeater("Обігрівач Ardesto", 1500, false);
        System.out.println(appliance + " -> за 2 год: " + appliance.getDailyConsumptionKWh(2) + " кВт·год");
        System.out.println(ecoOn + " -> за 8 год: " + ecoOn.getDailyConsumptionKWh(8) + " кВт·год");
        System.out.println(ecoOff + " -> за 8 год: " + ecoOff.getDailyConsumptionKWh(8) + " кВт·год");
    }

    static class Appliance {
        private String model;
        private double powerWatts;

        public Appliance(String model, double powerWatts) {
            this.model = model;
            this.powerWatts = Math.max(0.0, powerWatts);
        }

        public String getModel() {
            return model;
        }

        public double getPowerWatts() {
            return powerWatts;
        }

        public double getDailyConsumptionKWh(int hours) {
            return (powerWatts * hours) / 1000.0;
        }

        @Override
        public String toString() {
            return String.format("Appliance{model='%s', power=%.0f Вт}", model, powerWatts);
        }
    }

    static class EcoHeater extends Appliance {
        private boolean ecoModeActive;

        public EcoHeater(String model, double powerWatts, boolean ecoModeActive) {
            super(model, powerWatts);
            this.ecoModeActive = ecoModeActive;
        }

        @Override
        public double getDailyConsumptionKWh(int hours) {
            double normal = super.getDailyConsumptionKWh(hours);
            if (ecoModeActive) {
                return normal * 0.75;
            }
            return normal;
        }

        @Override
        public String toString() {
            return "EcoHeater{" + super.toString() + ", екорежим=" + (ecoModeActive ? "УВІМКНЕНО" : "вимкнено") + "}";
        }
    }
}
