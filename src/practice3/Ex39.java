package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть команду: ");
        String command = scanner.nextLine();

        // 1. Демонстрація, чому command == "start" повертає false:
        // Оператор == порівнює посилання на об'єкти в пам'яті (Heap), а не їх вміст.
        // Рядок, зчитаний через scanner.nextLine(), створюється як новий об'єкт у пам'яті,
        // тому його адреса не збігається з адресою константи "start" із String Pool.
        boolean isSameReference = (command == "start");
        // System.out.println("Результат порівняння через ==: " + isSameReference); // false

        // 2. Безпечна перевірка конкретної команди через equalsIgnoreCase
        if ("start".equalsIgnoreCase(command)) {
            // Безпечно до регістру та захищено від NullPointerException,
            // якщо викликати "start".equalsIgnoreCase(command)
        }

        // 3. Обробка всіх 4 команд через сучасний стрілочний switch
        String response = switch (command.toLowerCase()) {
            case "start" -> "Система успішно запущена!";
            case "pause" -> "Систему поставлено на паузу.";
            case "stop"  -> "Систему зупинено.";
            case "exit"  -> "Вихід з програми...";
            default      -> "Невідома команда!";
        };

        System.out.println(response);

        scanner.close();
    }
}
