package practice7;

public class Task19 {

    public double calculateArea(double side) {
        return side * side;
    }

    public double calculateArea(double width, double height) {
        return width * height;
    }

    public double calculateArea(double radius, boolean isCircle) {
        return Math.PI * radius * radius;
    }

    public double calculateArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double calculateArea(double base1, double base2, double height, boolean isTrapezoid) {
        return (base1 + base2) / 2 * height;
    }

    public static void main(String[] args) {
        Task19 calculator = new Task19();

        System.out.println("Квадрат зі стороною 5: " + calculator.calculateArea(5.0));
        System.out.println("Коло з радіусом 3: " + calculator.calculateArea(3.0, true));
        System.out.println("Прямокутник 4 x 7: " + calculator.calculateArea(4.0, 7.0));
        System.out.println("Трикутник 3, 4, 5: " + calculator.calculateArea(3.0, 4.0, 5.0));
        System.out.println("Трапеція 4, 6, висота 5: " + calculator.calculateArea(4.0, 6.0, 5.0, true));
    }
}
