package HomeWork3;

import java.util.Locale;
import java.util.Scanner;

/**
 * Завдання 2: Логістичний тарифікатор служби доставки з валідацією.
 * Теми: Scanner, очищення буфера, modern switch (->), каскад if-else-if,
 * .equalsIgnoreCase(), тернарний оператор, захист від некоректного вводу.
 */
public class Task2DeliveryService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Крапка як роздільник дробової частини (8.5, а не 8,5)
        scanner.useLocale(Locale.US);

        System.out.println("=== ТАРИФІКАТОР СЛУЖБИ ДОСТАВКИ ===");

        // 1. Введення даних (із захистом від нечислового вводу)
        System.out.print("Введіть вагу відправлення (кг): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Помилка: вага має бути числом!");
            scanner.close();
            return;
        }
        double weight = scanner.nextDouble();

        System.out.print("Введіть відстань транспортування (км): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Помилка: відстань має бути цілим числом!");
            scanner.close();
            return;
        }
        int distance = scanner.nextInt();

        System.out.print("Оберіть пункт призначення (1 - Відділення, 2 - Поштомат, 3 - Кур'єр): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Помилка: тип доставки має бути цілим числом!");
            scanner.close();
            return;
        }
        int deliveryType = scanner.nextInt();

        // Очищення буфера від символу '\n' після числових методів!
        scanner.nextLine();

        System.out.print("Чи є у вас карта Premium? (так/ні): ");
        String premiumAnswer = scanner.nextLine().trim();

        // 2. Валідація з конкретними повідомленнями про помилки
        if (weight <= 0) {
            System.out.println("Помилка: вага має бути більшою за 0 кг!");
            scanner.close();
            return;
        }
        if (weight > 50.0) {
            System.out.println("Помилка: вага відправлення не може перевищувати 50 кг!");
            scanner.close();
            return;
        }
        if (distance <= 0) {
            System.out.println("Помилка: відстань має бути більшою за 0 км!");
            scanner.close();
            return;
        }

        // 3. Базовий тариф через modern switch expression зі стрілками
        double baseTariff = switch (deliveryType) {
            case 1 -> 50.0;
            case 2 -> {
                if (weight > 15.0) {
                    System.out.println("Поштомат не підтримує вантажі понад 15 кг!");
                    yield -1;
                }
                yield 60.0;
            }
            case 3 -> 100.0;
            default -> -1;
        };

        if (baseTariff == -1) {
            if (deliveryType < 1 || deliveryType > 3) {
                System.out.println("Помилка: невідомий тип доставки!");
            }
            System.out.println("Розрахунок неможливий.");
            scanner.close();
            return;
        }

        String deliveryName = switch (deliveryType) {
            case 1 -> "Відділення";
            case 2 -> "Поштомат";
            default -> "Кур'єр";
        };

        // 4. Доплата за кілометраж: каскад if-else-if ladder
        double distanceSurcharge;
        if (distance <= 50) {
            distanceSurcharge = 0.0;
        } else if (distance <= 200) {
            distanceSurcharge = 35.0;
        } else {
            distanceSurcharge = 80.0;
        }

        // 5. Premium: .equalsIgnoreCase() + тернарний оператор (знижка 20% на весь чек)
        boolean isPremium = premiumAnswer.equalsIgnoreCase("так");
        double subtotal = baseTariff + distanceSurcharge;
        double total = isPremium ? subtotal * 0.80 : subtotal;
        String clientStatus = isPremium ? "Premium (-20%)" : "Стандартний (без знижки)";

        // 6. Розрахункова квитанція
        System.out.println();
        System.out.println("------------- НАКЛАДНА ДОСТАВКИ -------------");
        System.out.printf(Locale.US, "Тип доставки:              %s (базовий тариф: %.2f грн)%n", deliveryName, baseTariff);
        System.out.printf(Locale.US, "Доплата за відстань:       %.2f грн (%d км)%n", distanceSurcharge, distance);
        System.out.printf(Locale.US, "Сума до знижки:            %.2f грн%n", subtotal);
        System.out.printf(Locale.US, "Статус клієнта:            %s%n", clientStatus);
        System.out.println("---------------------------------------------");
        System.out.printf(Locale.US, "РАЗОМ ДО СПЛАТИ:           %.2f грн%n", total);
        System.out.println("=============================================");

        scanner.close();
    }
}
