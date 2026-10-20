package practice5;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }
        double avgPrecise = (double) sum / n;
        double avgImprecise = sum / n;
        System.out.println("Точне середнє: " + avgPrecise);
        System.out.println("Без приведення: " + avgImprecise);
        scanner.close();
    }
}
