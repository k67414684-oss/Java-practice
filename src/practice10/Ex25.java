package practice10;

public class Ex25 {
    public static void main(String[] args) {
        // Використовуємо класи з Ex2 (вони в тому самому пакеті semester1.practice10!)
        // Додамо локальні класи з методами getDiameter / getDiagonal для повної демонстрації
        record Circle(double r) { double getDiameter() { return 2 * r; } }
        record Rect(double w, double h) {
            double getDiagonal() { return Math.hypot(w, h); }
            boolean isSquare() { return Math.abs(w - h) < 1e-9; }
        }

        Object[] shapes = { new Circle(5.0), new Rect(4.0, 4.0), null };
        for (Object obj : shapes) {
            if (obj instanceof Circle c) {
                System.out.println("Коло -> діаметр: " + c.getDiameter());
            } else if (obj instanceof Rect r) {
                System.out.printf("Прямокутник -> діагональ: %.2f, квадрат: %b%n", r.getDiagonal(), r.isSquare());
            } else {
                System.out.println("null instanceof Object -> " + (obj instanceof Object));
            }
        }
    }
}
