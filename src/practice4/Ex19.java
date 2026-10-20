package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть чисельник: ");
        double numerator = scanner.nextDouble();
        double denominator;
        do {
            System.out.print("Введіть знаменник (не нуль): ");
            denominator = scanner.nextDouble();
        } while (denominator == 0);
        System.out.println("Результат ділення: " + (numerator / denominator));
        scanner.close();
    }
}