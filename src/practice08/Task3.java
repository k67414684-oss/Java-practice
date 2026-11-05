package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task3 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task3: Circle ---");
        Circle circle = new Circle(5);
        System.out.println(circle);
        Circle badCircle = new Circle(-2);
        System.out.println(badCircle);
        circle.setRadius(0);
        System.out.println(circle);
    }

    static class Circle {
        private double radius;

        public Circle(double radius) {
            setRadius(radius);
        }

        public double getRadius() {
            return radius;
        }

        public final void setRadius(double radius) {
            if (radius > 0) {
                this.radius = radius;
            } else {
                System.out.println("  [!] Радіус " + radius + " недопустимий, встановлено 1.0");
                this.radius = 1.0;
            }
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return String.format("Circle{radius=%.2f, area=%.2f, circumference=%.2f}",
                    radius, getArea(), getCircumference());
        }
    }
}
