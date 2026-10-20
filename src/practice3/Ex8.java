package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Товар: ");
        String a = scanner.nextLine();

        System.out.print("Ціна: ");
        double b = scanner.nextDouble();

        System.out.print("Кількість: ");
        int c = scanner.nextInt();

        double d = b * c;
        double e = d * 0.20;
        System.out.println("Загальна сума: " + " грн " + "(з них ПДВ 20%: " + e + " грн)");

        scanner.close();
    }
}