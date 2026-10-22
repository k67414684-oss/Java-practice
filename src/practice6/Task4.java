package practice6;

public class Task4 {

    public double width;
    public double height;

    public static void main(String[] args) {
        Task4 rectangle = new Task4();
        rectangle.width = 7.5;
        rectangle.height = 4.0;

        double area = rectangle.width * rectangle.height;
        double perimeter = 2 * (rectangle.width + rectangle.height);

        System.out.println("Ширина: " + rectangle.width + ", висота: " + rectangle.height);
        System.out.println("Площа: " + area);
        System.out.println("Периметр: " + perimeter);
    }
}
