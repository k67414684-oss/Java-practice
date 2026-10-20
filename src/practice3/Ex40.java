package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== БАНКОМАТ ==============");


        System.out.print("Введіть PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin != 1213) {
            System.out.println("Невірний PIN-код! Програму зупинено.");
            System.out.println("======================================");
            scanner.close();
            return; // Зупиняємо виконання програми
        }

        System.out.println("Авторизація успішна!\n");


        double balance = 5000.0;


        System.out.print("Оберіть дію (1 - Баланс, 2 - Поповнення, 3 - Зняття, 4 - Вихід): ");
        int choice = scanner.nextInt();


        switch (choice) {
            case 1 -> System.out.println("Ваш поточний баланс: " + balance + " грн");

            case 2 -> {
                System.out.print("Введіть суму поповнення: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    balance += depositAmount;
                    System.out.println("Рахунок поповнено! Поточний баланс: " + balance + " грн");
                } else {
                    System.out.println("Некоректна сума поповнення!");
                }
            }

            case 3 -> {

                System.out.print("Введіть суму зняття: ");
                double amount = scanner.nextDouble();


                if (amount > 0 && amount <= balance) {

                    double fee = (amount > 1000) ? amount * 0.01 : 0.0;


                    if (amount + fee <= balance) {
                        balance -= (amount + fee);
                        System.out.println("Комісія операції: " + fee + " грн");
                        System.out.println("Видано: " + amount + " грн. Залишок на рахунку: " + balance + " грн");
                    } else {
                        System.out.println("Недостатньо коштів на рахунку з урахуванням комісії!");
                    }
                } else {
                    System.out.println("Некоректна сума або недостатньо коштів на рахунку!");
                }
            }

            case 4 -> System.out.println("Дякуємо за використання нашого банкомату! До побачення.");

            default -> System.out.println("Некоректний вибір операції!");
        }

        System.out.println("======================================");
        scanner.close();
    }
}
