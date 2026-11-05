package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task5 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task5: SensorNode та protected ---");
        SensorNode node = new SensorNode("S-01", 21.4, 0.6);
        System.out.println(node);
        HeatSensor heat = new HeatSensor("H-07", 36.0, -0.5);
        System.out.println("До калібрування:    " + heat);
        heat.recalibrate(1.2);
        System.out.println("Після калібрування: " + heat);
    }

    static class SensorNode {
        private String sensorId;
        protected double calibrationOffset;
        private double rawValue;

        public SensorNode(String sensorId, double rawValue, double calibrationOffset) {
            this.sensorId = sensorId;
            this.rawValue = rawValue;
            this.calibrationOffset = calibrationOffset;
        }

        public String getSensorId() {
            return sensorId;
        }

        public double getRawValue() {
            return rawValue;
        }

        public double getCalibratedValue() {
            return rawValue + calibrationOffset;
        }

        @Override
        public String toString() {
            return String.format("SensorNode{id='%s', raw=%.2f, offset=%.2f, calibrated=%.2f}",
                    sensorId, rawValue, calibrationOffset, getCalibratedValue());
        }
    }

    static class HeatSensor extends SensorNode {

        public HeatSensor(String sensorId, double rawValue, double calibrationOffset) {
            super(sensorId, rawValue, calibrationOffset);
        }

        public void recalibrate(double extraOffset) {
            calibrationOffset += extraOffset;
        }

    }
}
