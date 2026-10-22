package practice6;

public class Task18 {

    public double radius;

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        Task18 circle = new Task18();
        circle.radius = 5.0;

        System.out.println("Радіус: " + circle.radius);
        System.out.println("Площа: " + circle.getArea());
        System.out.println("Довжина кола: " + circle.getCircumference());
    }
}
