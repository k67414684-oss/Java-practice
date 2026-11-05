package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task12 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task12: Rectangle -> Box3D ---");
        Rectangle rect = new Rectangle(4, 3);
        Box3D box = new Box3D(4, 3, 5);
        System.out.println(rect);
        System.out.println(box);
    }

    static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width > 0 ? width : 1.0;
            this.height = height > 0 ? height : 1.0;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        public double getArea() {
            return width * height;
        }

        @Override
        public String toString() {
            return String.format("Rectangle{width=%.2f, height=%.2f, area=%.2f}", width, height, getArea());
        }
    }

    static class Box3D extends Rectangle {
        private double depth;

        public Box3D(double width, double height, double depth) {
            super(width, height);
            this.depth = depth > 0 ? depth : 1.0;
        }

        public double getDepth() {
            return depth;
        }

        public double getVolume() {
            return super.getArea() * depth;
        }

        @Override
        public String toString() {
            return String.format("Box3D{base=%s, depth=%.2f, volume=%.2f}", super.toString(), depth, getVolume());
        }
    }
}
