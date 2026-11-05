package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task12 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task12: LineSegment ---");
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(6, 8);
        LineSegment segment = new LineSegment(p1, p2);
        p2.setLocation(100, 100);
        System.out.println(segment);
        System.out.println("Довжина: " + segment.getLength() + ", середина: " + segment.getMidpoint());
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

    static class LineSegment {
        private final Point2D start;
        private final Point2D end;

        public LineSegment(Point2D start, Point2D end) {
            this.start = new Point2D(start.getX(), start.getY());
            this.end = new Point2D(end.getX(), end.getY());
        }

        public double getLength() {
            return start.distanceTo(end);
        }

        public Point2D getMidpoint() {
            return new Point2D((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
        }

        @Override
        public String toString() {
            return "LineSegment{" + start + " -> " + end + "}";
        }
    }
}
