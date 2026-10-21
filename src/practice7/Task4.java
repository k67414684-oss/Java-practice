package practice7;

public class Task4 {

    private double x;
    private double y;

    public Task4() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Task4(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public double distanceTo(double targetX, double targetY) {
        double dx = targetX - x;
        double dy = targetY - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void printPoint() {
        System.out.println("Point(" + x + "; " + y + ")");
    }

    public static void main(String[] args) {
        Task4 p1 = new Task4();
        Task4 p2 = new Task4(3, 4);
        Task4 p3 = new Task4(-2.5, 6);

        p1.printPoint();
        p2.printPoint();
        p3.printPoint();

        System.out.println("Відстань p2 до початку координат: " + p2.distanceToOrigin());
        System.out.println("Відстань p3 до початку координат: " + p3.distanceToOrigin());
        System.out.println("Відстань p2 до точки (6; 8): " + p2.distanceTo(6, 8));
        System.out.println("Відстань p1 до p3: " + p1.distanceTo(-2.5, 6));
    }
}
