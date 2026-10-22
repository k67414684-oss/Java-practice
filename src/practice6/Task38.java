package practice6;

public class Task38 {

    private double[] coords = new double[3];

    public void setCoords(double x, double y, double z) {
        coords[0] = x;
        coords[1] = y;
        coords[2] = z;
    }

    public double getMagnitude() {
        return Math.sqrt(coords[0] * coords[0] + coords[1] * coords[1] + coords[2] * coords[2]);
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < coords.length; i++) {
            coords[i] = coords[i] * scalar;
        }
    }

    public void printVector() {
        System.out.println("(" + coords[0] + ", " + coords[1] + ", " + coords[2] + ")");
    }

    public static void main(String[] args) {
        Task38 vector = new Task38();
        vector.setCoords(2, 3, 6);

        System.out.print("Вектор: ");
        vector.printVector();
        System.out.println("Довжина: " + vector.getMagnitude());

        vector.multiplyByScalar(2);
        System.out.print("Після множення на 2: ");
        vector.printVector();
        System.out.println("Нова довжина: " + vector.getMagnitude());
    }
}
