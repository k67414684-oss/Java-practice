package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task35 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task35: LinearFunction -> QuadraticFunction ---");
        LinearFunction linear = new LinearFunction(2, 1);
        QuadraticFunction quadratic = new QuadraticFunction(1, -4, 3);
        System.out.println(linear + " | f(3) = " + linear.evaluate(3));
        System.out.println(quadratic + " | f(3) = " + quadratic.evaluate(3));
    }

    static class LinearFunction {
        protected double k;
        protected double b;

        public LinearFunction(double k, double b) {
            this.k = k;
            this.b = b;
        }

        public double evaluate(double x) {
            return k * x + b;
        }

        protected static String signed(double value) {
            if (value < 0) {
                return " - " + Math.abs(value);
            }
            return " + " + value;
        }

        @Override
        public String toString() {
            return "f(x) = " + k + "x" + signed(b);
        }
    }

    static class QuadraticFunction extends LinearFunction {
        private double a;

        public QuadraticFunction(double a, double k, double b) {
            super(k, b);

            this.a = (a != 0) ? a : 1.0;
        }

        @Override
        public double evaluate(double x) {
            return a * x * x + super.evaluate(x);
        }

        public double getVertexX() {
            return -k / (2 * a);
        }

        public double getVertexY() {
            return evaluate(getVertexX());
        }

        @Override
        public String toString() {
            return "f(x) = " + a + "x^2" + signed(k) + "x" + signed(b)
                    + " | вершина параболи: (" + getVertexX() + "; " + getVertexY() + ")";
        }
    }
}
