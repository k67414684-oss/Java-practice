package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        String result = (b != 0) ? String.valueOf(a / b) : "Помилка: ділення на нуль неможливе!";

        System.out.println(result);

        scanner.close();
    }
}
