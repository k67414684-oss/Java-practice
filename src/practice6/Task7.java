package practice6;

public class Task7 {

    public double x;
    public double y;

    public static void main(String[] args) {
        Task7 a = new Task7();
        a.x = 0;
        a.y = 0;

        Task7 b = new Task7();
        b.x = 3;
        b.y = 4;

        double distance = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));

        System.out.println("Точка A(" + a.x + ", " + a.y + ")");
        System.out.println("Точка B(" + b.x + ", " + b.y + ")");
        System.out.println("Відстань між точками: " + distance);
    }
}
