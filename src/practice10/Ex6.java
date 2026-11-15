package practice10;

abstract class DifferentiableFunction {
    public abstract String getTitle();
    public abstract double f(double x);
    public double derivativeAt(double x) {
        double h = 1e-5;
        return (f(x + h) - f(x - h)) / (2 * h);
    }
}
class QuadraticParabola extends DifferentiableFunction {
    private final double a, b, c;
    public QuadraticParabola(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
    @Override public String getTitle() { return a + "x^2 + " + b + "x + " + c; }
    @Override public double f(double x) { return a * x * x + b * x + c; }
}
class NaturalLogFunction extends DifferentiableFunction {
    private final double k;
    public NaturalLogFunction(double k) { this.k = k; }
    @Override public String getTitle() { return k + "*ln(x)"; }
    @Override public double f(double x) { return k * Math.log(x); }
}
class ExponentialGrowth extends DifferentiableFunction {
    private final double a, lambda;
    public ExponentialGrowth(double a, double lambda) { this.a = a; this.lambda = lambda; }
    @Override public String getTitle() { return a + "*e^(" + lambda + "x)"; }
    @Override public double f(double x) { return a * Math.exp(lambda * x); }
}

public class Ex6 {
    public static void main(String[] args) {
        DifferentiableFunction[] funcs = {
                new QuadraticParabola(2, 3, 1),
                new NaturalLogFunction(5),
                new ExponentialGrowth(1, 0.5)
        };
        double x = 2.0;
        for (DifferentiableFunction fn : funcs) {
            System.out.printf("%-18s | f(2.0) = %8.4f | f'(2.0) = %8.4f%n", fn.getTitle(), fn.f(x), fn.derivativeAt(x));
        }
    }
}
