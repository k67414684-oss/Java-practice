package HomeWork6;

import java.util.Locale;

public class Task1Fraction {

    public static void main(String[] args) {
        System.out.println("=== КАЛЬКУЛЯТОР ЗВИЧАЙНИХ ДРОБІВ ===");

        Fraction first = new Fraction();
        first.setValues(8, 12);
        System.out.print("Дріб 1: ");
        first.printFraction();
        System.out.println();

        first.simplify();
        System.out.print("Після скорочення: ");
        first.printFraction();
        System.out.printf(Locale.US, " (десятковий вигляд: %.4f)%n", first.toDecimal());

        Fraction second = new Fraction();
        second.setValues(3, 4);

        int a = first.getNumerator();
        int b = first.getDenominator();
        int c = second.getNumerator();
        int d = second.getDenominator();

        System.out.println();
        System.out.println("Додаємо дріб " + c + "/" + d + " до " + a + "/" + b + "...");
        first.add(c, d);

        System.out.print("Формула: " + a + "/" + b + " + " + c + "/" + d
                + " = (" + a + "*" + d + " + " + c + "*" + b + ") / (" + b + "*" + d + ") = ");
        first.printFraction();
        System.out.println();

        System.out.print("Результат додавання: ");
        first.printFraction();
        System.out.printf(Locale.US, " (десятковий вигляд: %.4f)%n", first.toDecimal());
        System.out.println("=====================================");
    }
}

class Fraction {
    private int numerator;
    private int denominator;

    public void setValues(int num, int den) {
        if (den == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            numerator = num;
            denominator = 1;
        } else if (den < 0) {
            numerator = -num;
            denominator = -den;
        } else {
            numerator = num;
            denominator = den;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void simplify() {
        int divider = gcd(numerator, denominator);
        if (divider != 0) {
            numerator = numerator / divider;
            denominator = denominator / divider;
        }
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public void add(int otherNum, int otherDen) {
        if (otherDen == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            return;
        }
        numerator = numerator * otherDen + otherNum * denominator;
        denominator = denominator * otherDen;
        simplify();
    }

    public void printFraction() {
        if (denominator == 1) {
            System.out.print(numerator);
        } else {
            System.out.print(numerator + "/" + denominator);
        }
    }
}
