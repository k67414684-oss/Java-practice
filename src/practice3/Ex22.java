package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сума покупки: ");
        double amount = scanner.nextDouble();

        double finalPrice = (amount > 1000) ? amount * 0.9 : amount * 0.98;

        System.out.printf("До сплати зі знижкою: %.1f грн%n", finalPrice);

        scanner.close();
    }
}
