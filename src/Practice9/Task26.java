package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task26 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task26: AbstractPowerPlant ---");
        AbstractPowerPlant[] plants = {
                new SolarPowerPlant("Сонячна-1", 100, 0.65),
                new WindPowerPlant("Вітрова-1", 60, 8.0),
                new WindPowerPlant("Вітрова-2", 60, 30.0),
                new WindPowerPlant("Вітрова-3", 60, 15.0)
        };
        for (AbstractPowerPlant plant : plants) {
            System.out.printf("%s: %.2f МВт, прибуток за добу при тарифі 1500: %.2f грн%n",
                    plant, plant.generateMegawatts(), plant.calculateDailyProfit(1500));
        }
    }

    static abstract class AbstractPowerPlant {
        private final String stationName;
        protected double baseCapacityMw;

        public AbstractPowerPlant(String stationName, double baseCapacityMw) {
            this.stationName = stationName;
            this.baseCapacityMw = Math.max(0.0, baseCapacityMw);
        }

        public abstract double generateMegawatts();

        public double calculateDailyProfit(double tariffPerMwh) {
            return generateMegawatts() * 24 * tariffPerMwh;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "{" + stationName + ", " + baseCapacityMw + " МВт}";
        }
    }

    static class SolarPowerPlant extends AbstractPowerPlant {
        private final double sunIntensityFactor;

        public SolarPowerPlant(String stationName, double baseCapacityMw, double sunIntensityFactor) {
            super(stationName, baseCapacityMw);
            this.sunIntensityFactor = Math.max(0.0, Math.min(1.0, sunIntensityFactor));
        }

        @Override
        public double generateMegawatts() {
            return baseCapacityMw * sunIntensityFactor;
        }
    }

    static class WindPowerPlant extends AbstractPowerPlant {
        private final double windSpeedMs;

        public WindPowerPlant(String stationName, double baseCapacityMw, double windSpeedMs) {
            super(stationName, baseCapacityMw);
            this.windSpeedMs = Math.max(0.0, windSpeedMs);
        }

        @Override
        public double generateMegawatts() {
            if (windSpeedMs < 3 || windSpeedMs > 25) {
                return 0.0;
            }
            double fraction = Math.min(1.0, (windSpeedMs - 3) / 9.0);
            return baseCapacityMw * fraction;
        }
    }
}
