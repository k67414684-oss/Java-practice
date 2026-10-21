package HomeWork6;

import java.util.Locale;

public class Task2QuadraticEquation {

    public static void main(String[] args) {
        System.out.println("=== РОЗВ'ЯЗУВАЧ КВАДРАТНИХ РІВНЯНЬ ===");

        QuadraticEquation first = new QuadraticEquation();
        first.setCoefficients(1, -5, 6);
        System.out.println("Тест 1:");
        first.printSolution();
        System.out.println("--------------------------------------");

        QuadraticEquation second = new QuadraticEquation();
        second.setCoefficients(1, -4, 4);
        System.out.println("Тест 2:");
        second.printSolution();
        System.out.println("--------------------------------------");

        QuadraticEquation third = new QuadraticEquation();
        third.setCoefficients(1, 2, 5);
        System.out.println("Тест 3:");
        third.printSolution();
        System.out.println("======================================");
    }
}

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public void setCoefficients(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Увага: коефіцієнт 'a' не може дорівнювати 0 (це лінійне рівняння)!");
            a = 1.0;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        if (!hasRealRoots()) {
            return Double.NaN;
        }
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }

    public double getRoot2() {
        if (!hasRealRoots()) {
            return Double.NaN;
        }
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }

    private String show(double number) {
        if (number < 0) {
            return "(" + number + ")";
        }
        return "" + number;
    }

    public void printSolution() {
        double d = getDiscriminant();
        System.out.println("Рівняння: " + a + "*x^2 + " + show(b) + "*x + " + show(c) + " = 0");
        System.out.printf(Locale.US, "Дискримінант D = %.2f%n", d);

        if (d > 0) {
            System.out.println("Рівняння має 2 дійсні корені:");
            System.out.printf(Locale.US, "  x1 = %.2f%n", getRoot1());
            System.out.printf(Locale.US, "  x2 = %.2f%n", getRoot2());
        } else if (d == 0) {
            System.out.println("Рівняння має один дійсний корінь:");
            System.out.printf(Locale.US, "  x = %.2f%n", -b / (2 * a));
        } else {
            System.out.println("Рівняння не має дійсних коренів у множині R.");
        }
    }
}
