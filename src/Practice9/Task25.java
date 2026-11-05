package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task25 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task25: AbstractShape ---");
        AbstractShape circle = new CircleShape("червоний", 3);
        AbstractShape rectangle = new RectangleShape("синій", 4, 6);
        System.out.println(circle);
        System.out.println(rectangle);
    }

    static abstract class AbstractShape {
        private final String color;

        public AbstractShape(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public abstract double getArea();

        public abstract double getPerimeter();

        @Override
        public String toString() {
            return String.format("%s{color=%s, S=%.2f, P=%.2f}", getClass().getSimpleName(), color, getArea(), getPerimeter());
        }
    }

    static class CircleShape extends AbstractShape {
        private final double radius;

        public CircleShape(String color, double radius) {
            super(color);
            this.radius = radius > 0 ? radius : 1.0;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    static class RectangleShape extends AbstractShape {
        private final double width;
        private final double height;

        public RectangleShape(String color, double width, double height) {
            super(color);
            this.width = width > 0 ? width : 1.0;
            this.height = height > 0 ? height : 1.0;
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + height);
        }
    }
}
