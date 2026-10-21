package practice7;

public class Task10 {

    private int numerator;
    private int denominator;

    public Task10(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати нулю!");
            denominator = 1;
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int a = Math.abs(numerator);
        int b = denominator;
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        this.numerator = numerator / a;
        this.denominator = denominator / a;
    }

    public Task10(int wholeNumber) {
        this(wholeNumber, 1);
    }

    public Task10() {
        this(0, 1);
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public static void main(String[] args) {
        Task10 f1 = new Task10(6, 8);
        Task10 f2 = new Task10(5);
        Task10 f3 = new Task10();
        Task10 f4 = new Task10(3, -9);
        Task10 f5 = new Task10(4, 0);

        f1.print();
        System.out.println(f1.toDouble());
        f2.print();
        System.out.println(f2.toDouble());
        f3.print();
        f4.print();
        System.out.println(f4.toDouble());
        f5.print();
    }
}
