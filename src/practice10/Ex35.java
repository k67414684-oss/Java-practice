package practice10;

interface MetricSpaceElement {
    double distanceTo(MetricSpaceElement other);
    double getNorm();
}
final class ImmutableVector3D implements MetricSpaceElement {
    private final double x, y, z;
    public ImmutableVector3D(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }
    @Override public double getNorm() { return Math.sqrt(x * x + y * y + z * z); }
    @Override public double distanceTo(MetricSpaceElement other) {
        if (other instanceof ImmutableVector3D v) {
            return Math.sqrt(Math.pow(x - v.x, 2) + Math.pow(y - v.y, 2) + Math.pow(z - v.z, 2));
        }
        return Math.abs(this.getNorm() - other.getNorm());
    }
}

public class Ex35 {
    public static void main(String[] args) {
        MetricSpaceElement v1 = new ImmutableVector3D(1, 2, 2);
        MetricSpaceElement v2 = new ImmutableVector3D(4, 6, 2);
        System.out.printf("Норма v1: %.2f | Відстань між v1 та v2: %.2f%n", v1.getNorm(), v1.distanceTo(v2));
    }
}
