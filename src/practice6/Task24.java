package practice6;

public class Task24 {

    private double a;
    private double b;
    private double c;

    public Task24(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isValid() {
        return a + b > c && a + c > b && b + c > a;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        if (!isValid()) {
            return 0.0;
        }
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        Task24 triangle = new Task24(3, 4, 5);
        System.out.println("Трикутник 3, 4, 5");
        System.out.println("Існує: " + triangle.isValid());
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Площа: " + triangle.getArea());

        Task24 wrong = new Task24(1, 2, 10);
        System.out.println("Трикутник 1, 2, 10");
        System.out.println("Існує: " + wrong.isValid());
        System.out.println("Площа: " + wrong.getArea());
    }
}
