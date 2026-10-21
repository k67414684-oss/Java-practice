package practice7;

public class Task39 {

    private double x;
    private double y;
    private double z;

    public Task39(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Task39() {
        this(0, 0, 0);
    }

    public Task39 add(Task39 other) {
        return new Task39(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public double dotProduct(Task39 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Task39 crossProduct(Task39 other) {
        double newX = this.y * other.z - this.z * other.y;
        double newY = this.z * other.x - this.x * other.z;
        double newZ = this.x * other.y - this.y * other.x;
        return new Task39(newX, newY, newZ);
    }

    public boolean isOrthogonalTo(Task39 other) {
        return dotProduct(other) == 0;
    }

    public boolean isEqualTo(Task39 other) {
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    public void print() {
        System.out.println("(" + x + "; " + y + "; " + z + ")");
    }

    public static void main(String[] args) {
        Task39 a = new Task39(1, 0, 0);
        Task39 b = new Task39(0, 1, 0);
        Task39 zero = new Task39();

        System.out.print("a + b = ");
        a.add(b).print();
        System.out.println("a * b (скалярний) = " + a.dotProduct(b));
        System.out.print("a x b (векторний) = ");
        a.crossProduct(b).print();
        System.out.println("a перпендикулярний b: " + a.isOrthogonalTo(b));
        System.out.println("a дорівнює b: " + a.isEqualTo(b));
        System.out.println("a дорівнює копії a: " + a.isEqualTo(new Task39(1, 0, 0)));
        System.out.print("Нульовий вектор: ");
        zero.print();
    }
}
