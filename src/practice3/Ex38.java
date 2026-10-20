package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Число 1: ");
        double a = scanner.nextDouble();


        System.out.print("Оберіть операцію (+, -, *, /): ");
        char op = scanner.next().charAt(0);


        System.out.print("Число 2: ");
        double b = scanner.nextDouble();


        Double result = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    System.out.println("Помилка: ділення на нуль неможливе!");
                    yield null;
                }
                yield a / b;
            }
            default -> {
                System.out.println("Помилка: невідома операція!");
                yield null;
            }
        };


        if (result != null) {
            System.out.println("Результат: " + result);
        }

        scanner.close();
    }
}
