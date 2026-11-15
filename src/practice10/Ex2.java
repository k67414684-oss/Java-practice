package practice10;

abstract class Shape2D {
    public abstract double getArea();
    public abstract double getPerimeter();
}

class CircleShape extends Shape2D {
    private final double r;
    public CircleShape(double r) { this.r = r; }
    @Override public double getArea() { return Math.PI * r * r; }
    @Override public double getPerimeter() { return 2 * Math.PI * r; }
}

class RectangleShape extends Shape2D {
    private final double a, b;
    public RectangleShape(double a, double b) { this.a = a; this.b = b; }
    @Override public double getArea() { return a * b; }
    @Override public double getPerimeter() { return 2 * (a + b); }
}

class EquilateralTriangleShape extends Shape2D {
    private final double a;
    public EquilateralTriangleShape(double a) { this.a = a; }
    @Override public double getArea() { return (Math.sqrt(3) / 4.0) * a * a; }
    @Override public double getPerimeter() { return 3 * a; }
}

public class Ex2 {
    public static Shape2D findMaxAreaShape(Shape2D[] shapes) {
        Shape2D max = shapes[0];
        for (Shape2D s : shapes) {
            if (s.getArea() > max.getArea()) max = s;
        }
        return max;
    }

    public static void main(String[] args) {
        Shape2D[] shapes = { new CircleShape(5.0), new RectangleShape(4.0, 6.0), new EquilateralTriangleShape(6.0) };
        Shape2D largest = findMaxAreaShape(shapes);
        System.out.printf("Найбільша фігура: %s (S = %.2f, P = %.2f)%n",
                largest.getClass().getSimpleName(), largest.getArea(), largest.getPerimeter());
    }
}
