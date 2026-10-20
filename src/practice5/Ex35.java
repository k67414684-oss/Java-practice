package practice5;

public class Ex {
    public static void main(String[] args) {
        for (double d = 0.0; d <= 1.0; d += 0.1) {
            System.out.println(d);
        }
        System.out.println("---");
        for (int i = 0; i <= 10; i++) {
            double val = i / 10.0;
            System.out.println(val);
        }
    }
}
