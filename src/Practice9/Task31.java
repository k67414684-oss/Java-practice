package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task31 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task31: AbstractSensor ---");
        PressureSensor pressure = new PressureSensor("Котельня", 1.0, 6.0, 4.2, 1.05);
        RadiationSensor radiation = new RadiationSensor("Сховище", 0.0, 0.3, 0.12);
        System.out.println(pressure);
        System.out.println(radiation);
        pressure.setRawReading(6.5);
        radiation.setBackground(0.9);
        System.out.println(pressure);
        System.out.println(radiation);
    }

    static abstract class AbstractSensor {
        private final String location;
        private final double minSafe;
        private final double maxSafe;

        public AbstractSensor(String location, double minSafe, double maxSafe) {
            this.location = location;
            this.minSafe = Math.min(minSafe, maxSafe);
            this.maxSafe = Math.max(minSafe, maxSafe);
        }

        public String getLocation() {
            return location;
        }

        public abstract double readValue();

        public abstract String getUnit();

        public final boolean isAlarmTriggered() {
            double value = readValue();
            return value < minSafe || value > maxSafe;
        }

        @Override
        public String toString() {
            return String.format("%s{%s: %.2f %s (норма %.2f..%.2f) -> %s}", getClass().getSimpleName(), location,
                    readValue(), getUnit(), minSafe, maxSafe, isAlarmTriggered() ? "ТРИВОГА!" : "норма");
        }
    }

    static class PressureSensor extends AbstractSensor {
        private double rawReading;
        private final double calibration;

        public PressureSensor(String location, double minSafe, double maxSafe, double rawReading, double calibration) {
            super(location, minSafe, maxSafe);
            this.rawReading = rawReading;
            this.calibration = calibration;
        }

        public void setRawReading(double rawReading) {
            this.rawReading = rawReading;
        }

        @Override
        public double readValue() {
            return rawReading * calibration;
        }

        @Override
        public String getUnit() {
            return "бар";
        }
    }

    static class RadiationSensor extends AbstractSensor {
        private double background;

        public RadiationSensor(String location, double minSafe, double maxSafe, double background) {
            super(location, minSafe, maxSafe);
            this.background = background;
        }

        public void setBackground(double background) {
            this.background = background;
        }

        @Override
        public double readValue() {
            return background;
        }

        @Override
        public String getUnit() {
            return "мкЗв/год";
        }
    }
}
