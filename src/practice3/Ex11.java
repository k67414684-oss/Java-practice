package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть вік: ");
        int age = scanner.nextInt();

        if (age < 0 || age > 120) {
            System.out.println("Некоректний вік");
        } else if (age <= 12) {
            System.out.println("Дитина");
        } else if (age <= 17) {
            System.out.println("Підліток");
        } else if (age <= 64) {
            System.out.println("Дорослий");
        } else {
            System.out.println("Пенсіонер");
        }
    }
}