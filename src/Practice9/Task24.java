package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task24 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task24: EquationSystem ---");
        EquationSystem system = new EquationSystem(3);
        system.addEquation(new LinearEquation(2, 3, 8));
        system.addEquation(new LinearEquation(4, -1, 2));
        System.out.println(system);
        System.out.println("(1; 2) розв'язок: " + system.checkSolution(1, 2));
        System.out.println("(2; 1) розв'язок: " + system.checkSolution(2, 1));
    }

    static class LinearEquation {
        private final double a;
        private final double b;
        private final double c;

        public LinearEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isSatisfiedBy(double x, double y) {
            return Math.abs(a * x + b * y - c) < 1e-6;
        }

        @Override
        public String toString() {
            return a + "x " + (b < 0 ? "- " : "+ ") + Math.abs(b) + "y = " + c;
        }
    }

    static class EquationSystem {
        private final LinearEquation[] equations;
        private int count;

        public EquationSystem(int capacity) {
            this.equations = new LinearEquation[Math.max(1, capacity)];
        }

        public boolean addEquation(LinearEquation equation) {
            if (equation == null || count >= equations.length) {
                return false;
            }
            equations[count++] = equation;
            return true;
        }

        public boolean checkSolution(double x, double y) {
            for (int i = 0; i < count; i++) {
                if (!equations[i].isSatisfiedBy(x, y)) {
                    return false;
                }
            }
            return count > 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Система:");
            for (int i = 0; i < count; i++) {
                sb.append("\n  ").append(equations[i]);
            }
            return sb.toString();
        }
    }
}
