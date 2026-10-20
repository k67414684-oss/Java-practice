package practice3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        System.out.print("Введіть суму в гривнях (UAH): ");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();

        System.out.print("Введіть курс USD: ");
        double b = scanner.nextDouble();

        double sum = Math.round((a / b) * 100.0) / 100.0;
        System.out.print("Сума до видачі: " + sum + " USD");

    }
}
