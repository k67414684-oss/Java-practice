package practice10;

interface Transformable2D {
    void translate(double dx, double dy);
    void scale(double factor);
}
class BoundingBox implements Transformable2D {
    double x, y, w, h;
    public BoundingBox(double x, double y, double w, double h) { this.x = x; this.y = y; this.w = w; this.h = h; }
    @Override public void translate(double dx, double dy) { x += dx; y += dy; }
    @Override public void scale(double f) { w *= f; h *= f; }
    @Override public String toString() { return String.format("Box(%.1f, %.1f, %.1fx%.1f)", x, y, w, h); }
}
class CircleRegion implements Transformable2D {
    double x, y, r;
    public CircleRegion(double x, double y, double r) { this.x = x; this.y = y; this.r = r; }
    @Override public void translate(double dx, double dy) { x += dx; y += dy; }
    @Override public void scale(double f) { r *= f; }
    @Override public String toString() { return String.format("Circle(%.1f, %.1f, r=%.1f)", x, y, r); }
}

public class Ex15 {
    public static void applyGlobalTransform(Transformable2D[] objects, double dx, double dy, double scaleFactor) {
        for (Transformable2D obj : objects) {
            obj.translate(dx, dy);
            obj.scale(scaleFactor);
        }
    }

    public static void main(String[] args) {
        Transformable2D[] scene = { new BoundingBox(0, 0, 10, 5), new CircleRegion(2, 3, 4) };
        applyGlobalTransform(scene, 5, 5, 2.0);
        for (Transformable2D t : scene) System.out.println(t);
    }
}
