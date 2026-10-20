package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть номер місяця (1–12): ");
        int month = scanner.nextInt();

        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11           -> 30;
            case 2                     -> 28;
            default                    -> 0;
        };

        if (days != 0) {
            System.out.println("Кількість днів у місяці: " + days);
        } else {
            System.out.println("Помилка: введено неіснуючий місяць!");
        }

        scanner.close();
    }
}
