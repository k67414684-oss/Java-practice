package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task35 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task35: LandPlot ---");
        LandPlot plot = new LandPlot(600, 5);
        System.out.println("Будинок 10x12: " + plot.addStructure(new RectangleShape("білий", 10, 12)));
        System.out.println("Гараж 6x5: " + plot.addStructure(new RectangleShape("сірий", 6, 5)));
        System.out.println("Клумба r=4: " + plot.addStructure(new CircleShape("зелений", 4)));
        System.out.println("Склад 20x15: " + plot.addStructure(new RectangleShape("жовтий", 20, 15)));
        System.out.println(plot);
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

    static class LandPlot {
        private final double totalPlotAreaM2;
        private final AbstractShape[] structures;
        private int count;

        public LandPlot(double totalPlotAreaM2, int capacity) {
            this.totalPlotAreaM2 = totalPlotAreaM2 > 0 ? totalPlotAreaM2 : 1.0;
            this.structures = new AbstractShape[Math.max(1, capacity)];
        }

        public double getBuiltArea() {
            double built = 0;
            for (int i = 0; i < count; i++) {
                built += structures[i].getArea();
            }
            return built;
        }

        public boolean addStructure(AbstractShape s) {
            if (s == null || count >= structures.length) {
                return false;
            }
            if (getBuiltArea() + s.getArea() > totalPlotAreaM2 * 0.6) {
                return false;
            }
            structures[count++] = s;
            return true;
        }

        public double getFreeGreenArea() {
            return totalPlotAreaM2 - getBuiltArea();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(String.format("LandPlot{%.0f м2", totalPlotAreaM2));
            for (int i = 0; i < count; i++) {
                sb.append("\n  ").append(structures[i]);
            }
            sb.append(String.format("%n  Забудовано: %.2f м2, вільний газон: %.2f м2}", getBuiltArea(), getFreeGreenArea()));
            return sb.toString();
        }
    }
}
