package practice4;

public class Ex {
    public static void main(String[] args) {
        for (int i = 100; i <= 200; i++) {
            if (i % 13 == 0 && i % 7 == 0) {
                System.out.println("Знайдене число: " + i);
                break;
            }
        }
    }
}