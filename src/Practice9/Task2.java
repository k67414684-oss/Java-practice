package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Task2 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task2: LabMeasurement ---");
        double[] external = {1.5, 2.5, 3.5};
        LabMeasurement measurement = new LabMeasurement("Опір провідника", external);
        external[0] = 999;
        System.out.println("Після зміни зовнішнього масиву: " + measurement);
        double[] leaked = measurement.getSamples();
        leaked[1] = -777;
        System.out.println("Після зміни масиву з геттера:  " + measurement);
        System.out.println("Масив з null: " + new LabMeasurement("Порожній", null));
    }

    static class LabMeasurement {
        private final String experimentName;
        private final double[] samples;

        public LabMeasurement(String experimentName, double[] samples) {
            this.experimentName = experimentName;
            this.samples = samples == null ? new double[0] : Arrays.copyOf(samples, samples.length);
        }

        public String getExperimentName() {
            return experimentName;
        }

        public double[] getSamples() {
            return Arrays.copyOf(samples, samples.length);
        }

        @Override
        public String toString() {
            return "LabMeasurement{name='" + experimentName + "', samples=" + Arrays.toString(samples) + "}";
        }
    }
}
