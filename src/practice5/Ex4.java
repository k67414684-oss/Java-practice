package practice5;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rate = scanner.nextDouble();

        for (int euro = 10; euro <= 100; euro += 10) {
            double uah = euro * rate;
            System.out.println(euro + " € = " + uah + " грн");
        }

        scanner.close();
    }
}