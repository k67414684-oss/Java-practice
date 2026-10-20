package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctPin = 1234;
        int attempts = 3;
        boolean accessGranted = false;

        do {
            System.out.print("Введіть PIN-код: ");
            int pin = scanner.nextInt();
            if (pin == correctPin) {
                accessGranted = true;
                break;
            } else {
                attempts--;
                System.out.println("Неправильний PIN. Залишилось спроб: " + attempts);
            }
        } while (attempts > 0);

        if (accessGranted) {
            System.out.println("Доступ надано");
        } else {
            System.out.println("Карту заблоковано!");
        }
        scanner.close();
    }
}