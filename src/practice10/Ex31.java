package practice10;

abstract class Matrix2x2 {
    double a11, a12, a21, a22;
    public Matrix2x2(double a11, double a12, double a21, double a22) {
        this.a11 = a11; this.a12 = a12; this.a21 = a21; this.a22 = a22;
    }
    public double determinant() { return a11 * a22 - a12 * a21; }
    @Override public String toString() { return String.format("[[%.2f, %.2f], [%.2f, %.2f]]", a11, a12, a21, a22); }
}
interface InvertibleMatrix { Matrix2x2 inverse(); }
interface OrthogonalMatrix { boolean checkOrthogonality(); }

class RotationMatrix2x2 extends Matrix2x2 implements InvertibleMatrix, OrthogonalMatrix {
    public RotationMatrix2x2(double deg) {
        super(Math.cos(Math.toRadians(deg)), -Math.sin(Math.toRadians(deg)),
              Math.sin(Math.toRadians(deg)), Math.cos(Math.toRadians(deg)));
    }
    @Override public Matrix2x2 inverse() { return new Matrix2x2(a11, a21, a12, a22) {}; }
    @Override public boolean checkOrthogonality() { return Math.abs(determinant() - 1.0) < 1e-6; }
}
class SingularMatrix2x2 extends Matrix2x2 {
    public SingularMatrix2x2() { super(1, 2, 2, 4); }
}

public class Ex31 {
    public static void main(String[] args) {
        Matrix2x2[] matrices = { new RotationMatrix2x2(60), new SingularMatrix2x2() };
        for (Matrix2x2 m : matrices) {
            if (m instanceof InvertibleMatrix inv) {
                System.out.println("Матриця оборотна! Обернена: " + inv.inverse());
            } else {
                System.out.println("Матриця вироджена (det = " + m.determinant() + "), оберненої не існує.");
            }
        }
    }
}
