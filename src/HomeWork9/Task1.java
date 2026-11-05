package HomeWork9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task1 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("================ ГЕОМЕТРИЧНЕ ПОЛОТНО (КОМПОЗИЦІЯ + ABSTRACT) ================");

        Point2D circleCenter = new Point2D(0, 0);
        GeometryCanvas canvas = new GeometryCanvas("Інженерне креслення №1", 5);
        canvas.addShape(new Circle2D("Коло-А", circleCenter, 5));
        canvas.addShape(new Rectangle2D("Плита-Б", new Point2D(10, 5), 4, 6));
        canvas.addShape(new RightTriangle2D("Клин-В", new Point2D(-3, 2), 3, 4));

        System.out.println(canvas);
        System.out.printf("Сумарна площа креслення:    %.2f кв.од.%n", canvas.getTotalArea());
        System.out.printf("Сумарний периметр:          %.2f од.%n", canvas.getTotalPerimeter());
        AbstractShape2D largest = canvas.findLargestShape();
        System.out.printf("Найбільша фігура:           %s (S = %.2f)%n", largest.getName(), largest.getArea());

        System.out.println("-> Переміщуємо всі фігури полотна на вектор (+5.0; -2.0)...");
        canvas.moveAllShapes(5.0, -2.0);
        System.out.println("Новий центр 'Коло-А': " + largest.getAnchorPoint());

        System.out.println();
        System.out.println("[ПЕРЕВІРКА ЗАХИСНОГО КОПІЮВАННЯ]:");
        circleCenter.translate(100, 100);
        System.out.println("Після зміни зовнішньої точки центр 'Коло-А': " + largest.getAnchorPoint());
        largest.getAnchorPoint().translate(-50, -50);
        System.out.println("Після зміни точки з геттера центр 'Коло-А':  " + largest.getAnchorPoint());
        System.out.println("Додати null на полотно: " + canvas.addShape(null));
        System.out.println("Некоректні параметри: " + new Circle2D("Помилка", null, -3));
        System.out.println("=============================================================================");
    }
    static class Point2D {
        private double x;
        private double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point2D(Point2D other) {
            this(other.x, other.y);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public void translate(double dx, double dy) {
            x += dx;
            y += dy;
        }

        public double distanceTo(Point2D other) {
            return Math.hypot(x - other.x, y - other.y);
        }

        @Override
        public String toString() {
            return String.format("(%.2f; %.2f)", x, y);
        }
    }

    static abstract class AbstractShape2D {
        private final String name;
        private final Point2D anchorPoint;

        public AbstractShape2D(String name, Point2D anchorPoint) {
            this.name = name;
            this.anchorPoint = (anchorPoint != null) ? new Point2D(anchorPoint) : new Point2D(0, 0);
        }

        public String getName() {
            return name;
        }

        public Point2D getAnchorPoint() {
            return new Point2D(anchorPoint);
        }

        public void moveBy(double dx, double dy) {
            anchorPoint.translate(dx, dy);
        }

        public abstract double getArea();

        public abstract double getPerimeter();

        protected String getDetails() {
            return "";
        }

        @Override
        public String toString() {
            return String.format("%s[name='%s', center=%s, %s | S=%.2f, P=%.2f]",
                    getClass().getSimpleName(), name, anchorPoint, getDetails(), getArea(), getPerimeter());
        }
    }

    static class Circle2D extends AbstractShape2D {
        private final double radius;

        public Circle2D(String name, Point2D center, double radius) {
            super(name, center);
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

        @Override
        protected String getDetails() {
            return String.format("r=%.2f", radius);
        }
    }

    static class Rectangle2D extends AbstractShape2D {
        private final double width;
        private final double height;

        public Rectangle2D(String name, Point2D center, double width, double height) {
            super(name, center);
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

        @Override
        protected String getDetails() {
            return String.format("%.2fx%.2f", width, height);
        }
    }

    static class RightTriangle2D extends AbstractShape2D {
        private final double legA;
        private final double legB;

        public RightTriangle2D(String name, Point2D center, double legA, double legB) {
            super(name, center);
            this.legA = legA > 0 ? legA : 1.0;
            this.legB = legB > 0 ? legB : 1.0;
        }

        public double getHypotenuse() {
            return Math.sqrt(legA * legA + legB * legB);
        }

        @Override
        public double getArea() {
            return 0.5 * legA * legB;
        }

        @Override
        public double getPerimeter() {
            return legA + legB + getHypotenuse();
        }

        @Override
        protected String getDetails() {
            return String.format("a=%.2f, b=%.2f, c=%.2f", legA, legB, getHypotenuse());
        }
    }

    static class GeometryCanvas {
        private final String title;
        private final AbstractShape2D[] shapes;
        private int count;

        public GeometryCanvas(String title, int capacity) {
            this.title = title;
            this.shapes = new AbstractShape2D[Math.max(1, capacity)];
        }

        public boolean addShape(AbstractShape2D shape) {
            if (shape == null || count >= shapes.length) {
                return false;
            }
            shapes[count++] = shape;
            return true;
        }

        public double getTotalArea() {
            double total = 0;
            for (int i = 0; i < count; i++) {
                total += shapes[i].getArea();
            }
            return total;
        }

        public double getTotalPerimeter() {
            double total = 0;
            for (int i = 0; i < count; i++) {
                total += shapes[i].getPerimeter();
            }
            return total;
        }

        public AbstractShape2D findLargestShape() {
            AbstractShape2D largest = null;
            for (int i = 0; i < count; i++) {
                if (largest == null || shapes[i].getArea() > largest.getArea()) {
                    largest = shapes[i];
                }
            }
            return largest;
        }

        public void moveAllShapes(double dx, double dy) {
            for (int i = 0; i < count; i++) {
                shapes[i].moveBy(dx, dy);
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Полотно: '").append(title).append("' (Фігур: ").append(count).append("/").append(shapes.length).append(")\n");
            for (int i = 0; i < count; i++) {
                sb.append("  ").append(i + 1).append(". ").append(shapes[i]).append("\n");
            }
            sb.append("-".repeat(77));
            return sb.toString();
        }
    }
}
