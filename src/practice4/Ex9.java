package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            count++;
            n /= 10;
        }

        System.out.println("Кількість цифр: " + count);
        System.out.println("Сума цифр: " + sum);
        scanner.close();
    }
}