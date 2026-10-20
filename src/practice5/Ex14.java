package practice5;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Розпочати нову гру");
            System.out.println("2. Завантажити збереження");
            System.out.println("3. Налаштування");
            System.out.println("0. Вихід");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Нова гра розпочата.");
                    break;
                case 2:
                    System.out.println("Збереження завантажено.");
                    break;
                case 3:
                    System.out.println("Відкриті налаштування.");
                    break;
                case 0:
                    System.out.println("Вихід з програми.");
                    break;
                default:
                    System.out.println("Невірний вибір.");
            }
        } while (choice != 0);
        scanner.close();
    }
}