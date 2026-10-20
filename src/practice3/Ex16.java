package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть обсяг спожитої електроенергії (в кВт·год): ");
        double kwh = scanner.nextDouble();

        double totalSum = 0;

        if (kwh <= 100) {
            totalSum = kwh * 2.64;
        } else {
            totalSum = (100 * 2.64) + ((kwh - 100) * 4.32);
        }

        System.out.printf("Сума до сплати: %.1f грн%n", totalSum);

        scanner.close();
    }
}
