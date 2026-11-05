package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task9 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task9: CompositeCircle ---");
        CompositeCircle circle = new CompositeCircle(2, 3, 5);
        System.out.println(circle);
        System.out.println("Точка (4; 5) всередині: " + circle.containsPoint(new Point2D(4, 5)));
        System.out.println("Точка (10; 10) всередині: " + circle.containsPoint(new Point2D(10, 10)));
    }

    static class Point2D {
        private double x;
        private double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point2D other) {
            return Math.hypot(x - other.x, y - other.y);
        }

        @Override
        public String toString() {
            return String.format("(%.2f; %.2f)", x, y);
        }
    }

    static class CompositeCircle {
        private double radius;
        private final Point2D center;

        public CompositeCircle(double centerX, double centerY, double radius) {
            this.center = new Point2D(centerX, centerY);
            this.radius = radius > 0 ? radius : 1.0;
        }

        public boolean containsPoint(Point2D p) {
            return center.distanceTo(p) <= radius;
        }

        @Override
        public String toString() {
            return "CompositeCircle{center=" + center + ", r=" + radius + "}";
        }
    }
}
