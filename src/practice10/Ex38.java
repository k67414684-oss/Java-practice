package practice10;

interface Integrable1D {
    double evaluate(double x);
    default double integrateTrapezoid(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (evaluate(a) + evaluate(b));
        for (int i = 1; i < n; i++) sum += evaluate(a + i * h);
        return sum * h;
    }
}
interface RootFindable { double findRootBisection(double left, double right, double eps); }

abstract class AbstractAnalyticFunction implements Integrable1D {}
class CubicFunction extends AbstractAnalyticFunction implements RootFindable {
    @Override public double evaluate(double x) { return x * x * x - 2 * x - 5; }
    @Override public double findRootBisection(double left, double right, double eps) {
        double a = left, b = right;
        while ((b - a) / 2.0 > eps) {
            double mid = (a + b) / 2.0;
            if (evaluate(mid) == 0.0) return mid;
            if (evaluate(a) * evaluate(mid) < 0) b = mid;
            else a = mid;
        }
        return (a + b) / 2.0;
    }
}

public class Ex38 {
    public static void main(String[] args) {
        CubicFunction fn = new CubicFunction();
        System.out.printf("Інтеграл на [0; 3]: %.6f%n", fn.integrateTrapezoid(0.0, 3.0, 1000));
        System.out.printf("Корінь на [2.0; 3.0]: %.6f%n", fn.findRootBisection(2.0, 3.0, 1e-6));
    }
}
