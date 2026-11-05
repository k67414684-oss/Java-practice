package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task17 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task17: Polyline ---");
        Polyline polyline = new Polyline(5);
        polyline.addVertex(0, 0);
        polyline.addVertex(4, 0);
        polyline.addVertex(4, 3);
        System.out.println(polyline);
        System.out.println("Довжина ламаної: " + polyline.getTotalLength());
        System.out.println("Периметр замкненої: " + polyline.getClosedPerimeter());
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

    static class Polyline {
        private final Point2D[] vertices;
        private int count;

        public Polyline(int maxVertices) {
            this.vertices = new Point2D[Math.max(2, maxVertices)];
        }

        public void addVertex(double x, double y) {
            if (count < vertices.length) {
                vertices[count++] = new Point2D(x, y);
            }
        }

        public double getTotalLength() {
            double sum = 0;
            for (int i = 1; i < count; i++) {
                sum += vertices[i - 1].distanceTo(vertices[i]);
            }
            return sum;
        }

        public double getClosedPerimeter() {
            if (count < 3) {
                return getTotalLength();
            }
            return getTotalLength() + vertices[count - 1].distanceTo(vertices[0]);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Polyline{");
            for (int i = 0; i < count; i++) {
                if (i > 0) {
                    sb.append(" -> ");
                }
                sb.append(vertices[i]);
            }
            return sb.append("}").toString();
        }
    }
}
