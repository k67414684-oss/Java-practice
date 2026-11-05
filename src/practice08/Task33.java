package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Task33 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task33: Progression -> Arithmetic, Geometric ---");
        Progression arithmetic = new ArithmeticProgression(2, 3);
        Progression geometric = new GeometricProgression(3, 2);
        System.out.println(arithmetic);
        System.out.println(geometric);
        System.out.println("10-й член арифметичної: " + arithmetic.getTerm(10));
        System.out.println("10-й член геометричної: " + geometric.getTerm(10));
    }

    static class Progression {
        protected double firstTerm;
        protected double step;

        public Progression(double firstTerm, double step) {
            this.firstTerm = firstTerm;
            this.step = step;
        }

        public double getTerm(int n) {
            return firstTerm;
        }

        public double[] generateFirstN(int n) {
            if (n < 0) {
                n = 0;
            }
            double[] result = new double[n];
            for (int i = 1; i <= n; i++) {
                result[i - 1] = getTerm(i);
            }
            return result;
        }

        @Override
        public String toString() {
            return "Progression{first=" + firstTerm + ", step=" + step + ", перші 5: "
                    + Arrays.toString(generateFirstN(5)) + "}";
        }
    }

    static class ArithmeticProgression extends Progression {

        public ArithmeticProgression(double firstTerm, double difference) {
            super(firstTerm, difference);
        }

        @Override
        public double getTerm(int n) {
            return firstTerm + (n - 1) * step;
        }

        @Override
        public String toString() {
            return "Арифметична прогресія: a_n = " + firstTerm + " + (n - 1) * " + step
                    + " | перші 5 членів: " + Arrays.toString(generateFirstN(5));
        }
    }

    static class GeometricProgression extends Progression {

        public GeometricProgression(double firstTerm, double ratio) {
            super(firstTerm, ratio);
        }

        @Override
        public double getTerm(int n) {
            return firstTerm * Math.pow(step, n - 1);
        }

        @Override
        public String toString() {
            return "Геометрична прогресія: b_n = " + firstTerm + " * " + step + "^(n - 1)"
                    + " | перші 5 членів: " + Arrays.toString(generateFirstN(5));
        }
    }
}
