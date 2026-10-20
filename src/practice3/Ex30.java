package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        boolean exists = (a + b > c) && (a + c > b) && (b + c > a);

        System.out.println("Трикутник існує: " + exists);

        scanner.close();
    }
}
