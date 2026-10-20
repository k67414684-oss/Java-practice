package practice3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваш зріст (м): ");
        double height = scanner.nextDouble();

        System.out.print("Ваша вага (кг): ");
        double weight = scanner.nextDouble();

        double result = Math.pow(height, 2) / weight;
        System.out.println("Розрахований BMI: " + Math.ceil(result));

    }
}
