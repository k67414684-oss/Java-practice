package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task39 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task39: SignalProcessor ---");
        SignalProcessor processor = new SignalProcessor(3);
        processor.addFilter(new AmplifierFilter(2.5));
        processor.addFilter(new ClippingFilter(5.0));
        double[] signal = {0.5, -1.0, 2.0, -4.0, 3.5};
        double[] result = processor.process(signal);
        signal[0] = 1000;
        System.out.println("Вхід:  " + java.util.Arrays.toString(new double[]{0.5, -1.0, 2.0, -4.0, 3.5}));
        System.out.println("Вихід: " + java.util.Arrays.toString(result));
        System.out.println(processor);
    }

    static abstract class AbstractFilter {
        private final String filterName;

        public AbstractFilter(String filterName) {
            this.filterName = filterName;
        }

        public String getFilterName() {
            return filterName;
        }

        public abstract double processSample(double x);
    }

    static class AmplifierFilter extends AbstractFilter {
        private final double gain;

        public AmplifierFilter(double gain) {
            super("Підсилювач x" + gain);
            this.gain = gain;
        }

        @Override
        public double processSample(double x) {
            return x * gain;
        }
    }

    static class ClippingFilter extends AbstractFilter {
        private final double threshold;

        public ClippingFilter(double threshold) {
            super("Обмежувач ±" + Math.abs(threshold));
            this.threshold = Math.abs(threshold);
        }

        @Override
        public double processSample(double x) {
            return Math.max(-threshold, Math.min(threshold, x));
        }
    }

    static class SignalProcessor {
        private final AbstractFilter[] pipeline;
        private int filterCount;

        public SignalProcessor(int capacity) {
            this.pipeline = new AbstractFilter[Math.max(1, capacity)];
        }

        public boolean addFilter(AbstractFilter filter) {
            if (filter == null || filterCount >= pipeline.length) {
                return false;
            }
            pipeline[filterCount++] = filter;
            return true;
        }

        public double[] process(double[] signal) {
            double[] result = signal == null ? new double[0] : java.util.Arrays.copyOf(signal, signal.length);
            for (int f = 0; f < filterCount; f++) {
                for (int i = 0; i < result.length; i++) {
                    result[i] = pipeline[f].processSample(result[i]);
                }
            }
            return result;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("SignalProcessor{");
            for (int i = 0; i < filterCount; i++) {
                if (i > 0) {
                    sb.append(" -> ");
                }
                sb.append(pipeline[i].getFilterName());
            }
            return sb.append("}").toString();
        }
    }
}
