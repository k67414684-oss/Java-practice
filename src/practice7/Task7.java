package practice7;

public class Task7 {

    private double width;
    private double height;

    public Task7() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public Task7(double size) {
        this.width = size;
        this.height = size;
    }

    public Task7(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }

    public static void main(String[] args) {
        Task7 unit = new Task7();
        Task7 square = new Task7(5);
        Task7 rect = new Task7(4, 6);

        System.out.println("Одиничний: площа " + unit.getArea() + ", периметр " + unit.getPerimeter() + ", квадрат: " + unit.isSquare());
        System.out.println("Квадрат: площа " + square.getArea() + ", периметр " + square.getPerimeter() + ", квадрат: " + square.isSquare());
        System.out.println("Прямокутник: площа " + rect.getArea() + ", периметр " + rect.getPerimeter() + ", квадрат: " + rect.isSquare());

        if (square.getArea() > rect.getArea()) {
            System.out.println("Площа квадрата більша");
        } else if (square.getArea() < rect.getArea()) {
            System.out.println("Площа прямокутника більша");
        } else {
            System.out.println("Площі однакові");
        }

        if (square.getPerimeter() > rect.getPerimeter()) {
            System.out.println("Периметр квадрата більший");
        } else if (square.getPerimeter() < rect.getPerimeter()) {
            System.out.println("Периметр прямокутника більший");
        } else {
            System.out.println("Периметри однакові");
        }
    }
}
