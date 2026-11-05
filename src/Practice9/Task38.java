package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task38 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task38: SmartLab ---");
        PressureSensor pressure = new PressureSensor("Реактор", 1.0, 6.0, 4.0, 1.0);
        RadiationSensor radiation = new RadiationSensor("Хол", 0.0, 0.3, 0.1);
        SmartLab lab = new SmartLab("Лабораторія-7", 4);
        lab.addSensor(pressure);
        lab.addSensor(radiation);
        lab.runDiagnostics();
        radiation.setBackground(1.2);
        lab.runDiagnostics();
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

    static class EmergencySiren {
        private boolean sounding;

        public void activate() {
            sounding = true;
        }

        public void deactivate() {
            sounding = false;
        }

        public boolean isSounding() {
            return sounding;
        }
    }

    static class SmartLab {
        private final String labName;
        private final EmergencySiren siren = new EmergencySiren();
        private final AbstractSensor[] sensors;
        private int sensorCount;

        public SmartLab(String labName, int capacity) {
            this.labName = labName;
            this.sensors = new AbstractSensor[Math.max(1, capacity)];
        }

        public boolean addSensor(AbstractSensor sensor) {
            if (sensor == null || sensorCount >= sensors.length) {
                return false;
            }
            sensors[sensorCount++] = sensor;
            return true;
        }

        public void runDiagnostics() {
            System.out.println("Діагностика '" + labName + "':");
            boolean alarm = false;
            for (int i = 0; i < sensorCount; i++) {
                System.out.println("  " + sensors[i]);
                if (sensors[i].isAlarmTriggered()) {
                    alarm = true;
                }
            }
            if (alarm) {
                siren.activate();
            } else {
                siren.deactivate();
            }
            System.out.println("  Сирена: " + (siren.isSounding() ? "ВИЄ!" : "мовчить"));
        }
    }
}
