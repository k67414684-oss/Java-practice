package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task23 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task23: Point2D -> Point3D ---");
        Point2D p2 = new Point2D(3, 4);
        Point3D p3 = new Point3D(2, 3, 6);
        System.out.println("Точка " + p2 + ", відстань до початку: " + p2.distanceToOrigin());
        System.out.println("Точка " + p3 + ", відстань до початку: " + p3.distanceToOrigin());
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

        public double distanceToOrigin() {
            return Math.sqrt(x * x + y * y);
        }

        @Override
        public String toString() {
            return "(" + x + "; " + y + ")";
        }
    }

    static class Point3D extends Point2D {
        private double z;

        public Point3D(double x, double y, double z) {
            super(x, y);
            this.z = z;
        }

        public double getZ() {
            return z;
        }

        @Override
        public double distanceToOrigin() {
            return Math.sqrt(Math.pow(super.distanceToOrigin(), 2) + z * z);
        }

        @Override
        public String toString() {
            return "(" + getX() + "; " + getY() + "; " + z + ")";
        }
    }
}
