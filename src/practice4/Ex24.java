package practice4;

public class Ex {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}