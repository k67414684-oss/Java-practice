package practice10;

class VectorMathOverload {
    public double norm(double x) { return Math.abs(x); }
    public double norm(double x, double y) { return Math.hypot(x, y); }
    public double norm(double[] v) {
        double sum = 0;
        for (double val : v) sum += val * val;
        return Math.sqrt(sum);
    }
}

abstract class BinaryOperation {
    public abstract double apply(double a, double b);
}
class AddOp extends BinaryOperation { @Override public double apply(double a, double b) { return a + b; } }
class MultiplyOp extends BinaryOperation { @Override public double apply(double a, double b) { return a * b; } }
class HypotenuseOp extends BinaryOperation { @Override public double apply(double a, double b) { return Math.hypot(a, b); } }

public class Ex3 {
    public static void main(String[] args) {
        VectorMathOverload vmo = new VectorMathOverload();
        System.out.println("Static Overloading: 1D=" + vmo.norm(-5) + ", 2D=" + vmo.norm(3, 4) + ", nD=" + vmo.norm(new double[]{1, 2, 2}));

        BinaryOperation[] ops = { new AddOp(), new MultiplyOp(), new HypotenuseOp() };
        for (BinaryOperation op : ops) {
            System.out.println(op.getClass().getSimpleName() + "(3.0, 4.0) = " + op.apply(3.0, 4.0));
        }
    }
}
