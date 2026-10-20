package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть початкову суму (S): ");
        double currentAmount = scanner.nextDouble();

        System.out.print("Введіть річний відсоток (P): ");
        double percent = scanner.nextDouble();

        double targetAmount = currentAmount * 2;
        int years = 0;

        while (currentAmount < targetAmount) {
            currentAmount += currentAmount * (percent / 100);
            years++;
        }

        System.out.println("Сума збільшиться щонайменше вдвічі через " + years + " років (років/роки).");
        System.out.printf("Підсумкова сума становитиме: %.2f грн\n", currentAmount);

        scanner.close();
    }
}