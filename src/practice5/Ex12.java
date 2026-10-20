package practice5;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть число N (N > 1): ");
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println("Помилка: число має бути більше за 1.");
            return;
        }

        int divisor = 2;

        while (n % divisor != 0) {
            divisor++;
        }

        System.out.println("Найменший дільник числа " + n + " (відмінний від 1) дорівнює: " + divisor);

        scanner.close();
    }
}