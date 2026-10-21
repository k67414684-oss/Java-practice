package HomeWork3;

import java.util.Locale;
import java.util.Scanner;

/**
 * Завдання 1: Розумний калькулятор витрати пального та вартості поїздки.
 * Теми: Scanner, switch, if-else, тернарний оператор ?:, закриття ресурсів.
 */
public class Task1FuelCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Крапка як роздільник дробової частини (450.5, а не 450,5)
        scanner.useLocale(Locale.US);

        System.out.println("=== КАЛЬКУЛЯТОР ПОЇЗДКИ ТА ПАЛЬНОГО ===");

        // 1-2. Введення даних (із захистом від нечислового вводу)
        System.out.print("Введіть відстань поїздки (км): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Помилка: відстань має бути числом!");
            scanner.close();
            return;
        }
        double distance = scanner.nextDouble();

        System.out.print("Введіть середню витрату на 100 км (л): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Помилка: витрата пального має бути числом!");
            scanner.close();
            return;
        }
        double fuelConsumption = scanner.nextDouble();

        System.out.print("Оберіть тип пального (1 - А-95, 2 - Дизель, 3 - Газ): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Помилка: тип пального має бути цілим числом!");
            scanner.close();
            return;
        }
        int fuelType = scanner.nextInt();

        // 3. Валідація вхідних даних
        if (distance <= 0 || fuelConsumption <= 0) {
            System.out.println("Помилка: відстань та витрата пального мають бути більшими за 0!");
            scanner.close();
            return;
        }

        // 4. Визначення ціни 1 літра через switch (з гілкою default)
        double pricePerLiter;
        String fuelName;
        switch (fuelType) {
            case 1 -> {
                pricePerLiter = 56.50;
                fuelName = "Бензин А-95";
            }
            case 2 -> {
                pricePerLiter = 52.80;
                fuelName = "Дизель";
            }
            case 3 -> {
                pricePerLiter = 29.40;
                fuelName = "Газ";
            }
            default -> {
                System.out.println("Помилка: невідомий тип пального! Розрахунок завершено.");
                scanner.close();
                return;
            }
        }

        // 5. Розрахунок об'єму пального та базової вартості
        double neededFuel = distance * fuelConsumption / 100.0;
        double baseCost = neededFuel * pricePerLiter;

        // 6. Тернарний оператор: знижка 5% на АЗС, якщо базова вартість >= 2000 грн
        double finalCost = (baseCost >= 2000.0) ? baseCost * 0.95 : baseCost;
        double discountAmount = baseCost - finalCost;
        String discountPercent = (baseCost >= 2000.0) ? "5%" : "0%";

        // 7. Звіт
        System.out.println();
        System.out.println("---------------- ЗВІТ ПОЇЗДКИ ----------------");
        System.out.printf(Locale.US, "Обране пальне:               %s (%.2f грн/л)%n", fuelName, pricePerLiter);
        System.out.printf(Locale.US, "Необхідно пального:          %.2f л%n", neededFuel);
        System.out.printf(Locale.US, "Базова вартість:             %.2f грн%n", baseCost);
        System.out.printf(Locale.US, "Знижка АЗС (%s):             %.2f грн%n", discountPercent, discountAmount);
        System.out.println("----------------------------------------------");
        System.out.printf(Locale.US, "Підсумкова сума до сплати:   %.2f грн%n", finalCost);
        System.out.println("==============================================");

        // 8. Закриття ресурсу
        scanner.close();
    }
}
