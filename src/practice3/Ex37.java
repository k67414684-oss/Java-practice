package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Оберіть спосіб доставки (1 - Самовивіз, 2 - Кур'єр, 3 - Поштомат): ");
        int deliveryType = scanner.nextInt();

        System.out.print("Введіть вагу товару (кг): ");
        double weight = scanner.nextDouble();


        int deliveryCost = switch (deliveryType) {
            case 1 -> 0;
            case 2 -> {

                if (weight > 5) {
                    yield 150;
                } else {
                    yield 90;
                }
            }
            case 3 -> 60;
            default -> -1;
        };

        if (deliveryCost != -1) {
            System.out.println("Вартість доставки: " + deliveryCost + " грн.");
        } else {
            System.out.println("Некоректний вибір способу доставки!");
        }

        scanner.close();
    }
}
