package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task16 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task16: ClimateController ---");
        ClimateController climate = new ClimateController(22.0, 18.0, 2.5);
        double[] temps = {18.0, 21.0, 21.7, 22.0, 21.8, 21.4, 20.9};
        for (double t : temps) {
            climate.updateTemperature(t);
            climate.regulate();
            System.out.println(climate);
        }
    }

    static class TemperatureSensor {
        private double currentTemp;

        public TemperatureSensor(double currentTemp) {
            this.currentTemp = currentTemp;
        }

        public double getCurrentTemp() {
            return currentTemp;
        }

        public void setCurrentTemp(double currentTemp) {
            this.currentTemp = currentTemp;
        }
    }

    static class HeatingUnit {
        private boolean heatingOn;
        private final double powerKw;

        public HeatingUnit(double powerKw) {
            this.powerKw = Math.max(0.1, powerKw);
        }

        public void turnOn() {
            heatingOn = true;
        }

        public void turnOff() {
            heatingOn = false;
        }

        public boolean isHeatingOn() {
            return heatingOn;
        }

        public double getPowerKw() {
            return powerKw;
        }
    }

    static class ClimateController {
        private final TemperatureSensor sensor;
        private final HeatingUnit heatingUnit;
        private double targetTemp;

        public ClimateController(double targetTemp, double currentTemp, double powerKw) {
            this.targetTemp = targetTemp;
            this.sensor = new TemperatureSensor(currentTemp);
            this.heatingUnit = new HeatingUnit(powerKw);
        }

        public void updateTemperature(double temp) {
            sensor.setCurrentTemp(temp);
        }

        public void regulate() {
            double current = sensor.getCurrentTemp();
            if (current < targetTemp - 0.5) {
                heatingUnit.turnOn();
            } else if (current >= targetTemp) {
                heatingUnit.turnOff();
            }
        }

        @Override
        public String toString() {
            return String.format("ClimateController{target=%.1f, current=%.1f, обігрів: %s (%.1f кВт)}",
                    targetTemp, sensor.getCurrentTemp(), heatingUnit.isHeatingOn() ? "УВІМКНЕНО" : "вимкнено",
                    heatingUnit.getPowerKw());
        }
    }
}
