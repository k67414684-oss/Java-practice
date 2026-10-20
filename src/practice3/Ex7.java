package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Катет A: ");
        double a = scanner.nextDouble();

        System.out.print("Катет B: ");
        double b = scanner.nextDouble();

        double square = Math.pow(a, 2) + Math.pow(b, 2);
        double hypotenuse = Math.sqrt(square);
        System.out.println("Гіпотенуза: " + hypotenuse);

        double perimeter = a + b + hypotenuse;
        System.out.println("Периметр: " + perimeter);

        double area = (a * b) / 2.0;
        System.out.println("Площа: " + area);



        scanner.close();
    }
}