package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Task7 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task7: EncapsulatedPolynomial ---");
        double[] coeffs = {1, -3, 0, 2};
        EncapsulatedPolynomial poly = new EncapsulatedPolynomial(coeffs);
        coeffs[0] = 100;
        System.out.println(poly);
        System.out.println("Степінь: " + poly.getDegree());
        System.out.println("c2 = " + poly.getCoefficient(2) + ", c10 = " + poly.getCoefficient(10));
        System.out.println("P(2) = " + poly.evaluate(2));
    }

    static class EncapsulatedPolynomial {
        private final double[] coeffs;

        public EncapsulatedPolynomial(double[] coeffs) {
            if (coeffs == null || coeffs.length == 0) {
                this.coeffs = new double[]{0.0};
            } else {
                this.coeffs = Arrays.copyOf(coeffs, coeffs.length);
            }
        }

        public int getDegree() {
            for (int i = coeffs.length - 1; i > 0; i--) {
                if (coeffs[i] != 0) {
                    return i;
                }
            }
            return 0;
        }

        public double getCoefficient(int power) {
            if (power < 0 || power >= coeffs.length) {
                return 0.0;
            }
            return coeffs[power];
        }

        public double evaluate(double x) {
            double result = 0;
            for (int i = coeffs.length - 1; i >= 0; i--) {
                result = result * x + coeffs[i];
            }
            return result;
        }

        private static String format(double value) {
            if (value == Math.rint(value)) {
                return String.valueOf((long) value);
            }
            return String.format("%.2f", value);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("P(x) = ");
            boolean first = true;
            for (int i = 0; i < coeffs.length; i++) {
                double c = coeffs[i];
                if (c == 0 && !(first && i == coeffs.length - 1)) {
                    continue;
                }
                if (first) {
                    sb.append(c < 0 ? "-" : "");
                } else {
                    sb.append(c < 0 ? " - " : " + ");
                }
                double abs = Math.abs(c);
                if (i == 0) {
                    sb.append(format(abs));
                } else {
                    if (abs != 1) {
                        sb.append(format(abs));
                    }
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
                first = false;
            }
            return sb.toString();
        }
    }
}
