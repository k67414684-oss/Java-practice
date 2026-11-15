package practice10;

class Vec2D {
    final double x, y;
    public Vec2D(double x, double y) { this.x = x; this.y = y; }
    @Override public String toString() { return String.format("(%.2f, %.2f)", x, y); }
}
abstract class AbstractVectorOperator {
    private final String name;
    public AbstractVectorOperator(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract Vec2D transform(Vec2D v);
}
interface InvertibleOperator { Vec2D inverseTransform(Vec2D v); }

class Rotation2DOperator extends AbstractVectorOperator implements InvertibleOperator {
    private final double rad;
    public Rotation2DOperator(double deg) { super("Rotate(" + deg + "°)"); this.rad = Math.toRadians(deg); }
    @Override public Vec2D transform(Vec2D v) {
        return new Vec2D(v.x * Math.cos(rad) - v.y * Math.sin(rad), v.x * Math.sin(rad) + v.y * Math.cos(rad));
    }
    @Override public Vec2D inverseTransform(Vec2D v) {
        return new Vec2D(v.x * Math.cos(-rad) - v.y * Math.sin(-rad), v.x * Math.sin(-rad) + v.y * Math.cos(-rad));
    }
}
class ProjectionXOperator extends AbstractVectorOperator {
    public ProjectionXOperator() { super("ProjX"); }
    @Override public Vec2D transform(Vec2D v) { return new Vec2D(v.x, 0.0); }
}

public class Ex20 {
    public static void main(String[] args) {
        Vec2D v = new Vec2D(3.0, 4.0);
        AbstractVectorOperator[] ops = { new Rotation2DOperator(90), new ProjectionXOperator() };
        for (AbstractVectorOperator op : ops) {
            Vec2D res = op.transform(v);
            System.out.print(op.getName() + ": " + v + " -> " + res);
            if (op instanceof InvertibleOperator inv) System.out.print(" -> обернене: " + inv.inverseTransform(res));
            System.out.println();
        }
    }
}
