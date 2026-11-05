package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task30 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task30: Segment1D -> Square2D -> Cube3D ---");
        Segment1D segment = new Segment1D(3);
        Square2D square = new Square2D(3);
        Cube3D cube = new Cube3D(3);
        System.out.println(segment);
        System.out.println(square);
        System.out.println(cube);
    }

    static class Segment1D {
        protected double length;

        public Segment1D(double length) {
            this.length = length > 0 ? length : 1.0;
        }

        public double getLength() {
            return length;
        }

        @Override
        public String toString() {
            return String.format("Segment1D{length=%.2f}", length);
        }
    }

    static class Square2D extends Segment1D {

        public Square2D(double side) {
            super(side);
        }

        public double getPerimeter() {
            return 4 * length;
        }

        public double getArea() {
            return length * length;
        }

        @Override
        public String toString() {
            return String.format("Square2D{%s, P=%.2f, S=%.2f}", super.toString(), getPerimeter(), getArea());
        }
    }

    static class Cube3D extends Square2D {

        public Cube3D(double side) {
            super(side);
        }

        @Override
        public double getArea() {
            return 6 * super.getArea();
        }

        public double getVolume() {
            return length * length * length;
        }

        @Override
        public String toString() {
            return String.format("Cube3D{%s, V=%.2f}", super.toString(), getVolume());
        }
    }
}
