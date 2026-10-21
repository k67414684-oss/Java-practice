package HomeWork5;

import java.util.Locale;
import java.util.Scanner;

public class Task1DailySales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        double[] sales = new double[7];

        System.out.println("=== ФІНАНСОВИЙ ЗВІТ КАВ'ЯРНІ ЗА ТИЖДЕНЬ ===");

        for (int i = 0; i < sales.length; i++) {
            System.out.print("Введіть виторг за " + days[i] + " (грн): ");
            sales[i] = scanner.nextDouble();
        }

        double total = 0;
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < sales.length; i++) {
            total += sales[i];
            if (sales[i] > sales[maxIndex]) {
                maxIndex = i;
            }
            if (sales[i] < sales[minIndex]) {
                minIndex = i;
            }
        }

        double average = total / sales.length;

        System.out.println();
        System.out.println("---------------- ПІДСУМКИ ----------------");
        System.out.printf(Locale.US, "Загальний тижневий виторг: %.2f грн%n", total);
        System.out.printf(Locale.US, "Середній виторг на день:    %.2f грн%n", average);
        System.out.printf(Locale.US, "Найкращий день:            %s (%.2f грн)%n", days[maxIndex], sales[maxIndex]);
        System.out.printf(Locale.US, "Найгірший день:            %s (%.2f грн)%n", days[minIndex], sales[minIndex]);

        System.out.println();
        System.out.println("Дні з виторгом вище середнього:");
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > average) {
                System.out.printf(Locale.US, "- %-10s %.2f грн%n", days[i] + ":", sales[i]);
            }
        }
        System.out.println("==========================================");

        scanner.close();
    }
}
