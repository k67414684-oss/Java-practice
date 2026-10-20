package practice6;

import java.util.Scanner;

public class Task1DailySales {
    public static void main(String[] args) {
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        double[] sales = new double[7];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < days.length; i++) {
            sales[i] = scanner.nextDouble();
        }

        double total = 0;
        for (int i = 0; i < sales.length; i++) {
            total += sales[i];
        }

        double average = total / sales.length;

        double maxSales = sales[0];
        int maxIndex = 0;
        double minSales = sales[0];
        int minIndex = 0;

        for (int i = 1; i < sales.length; i++) {
            if (sales[i] > maxSales) {
                maxSales = sales[i];
                maxIndex = i;
            }
            if (sales[i] < minSales) {
                minSales = sales[i];
                minIndex = i;
            }
        }

        System.out.println("Загальний виторг: " + total);
        System.out.println("Середньоденний виторг: " + average);
        System.out.println("Найприбутковіший день: " + days[maxIndex] + " (" + maxSales + ")");
        System.out.println("Найменш прибутковий день: " + days[minIndex] + " (" + minSales + ")");

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > average) {
                System.out.println(days[i]);
            }
        }
    }
}
