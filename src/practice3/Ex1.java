package practice3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        System.out.println("=== ВХІДНІ ДАНІ ===");
        System.out.print("Ім'я: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.print("Прізвище: ");
        String surname = scanner.next();
        System.out.print("Вік: ");
        int age = scanner.nextInt();
        System.out.print("Місто: ");
        String city = scanner.next();
        System.out.println("-------------------");
        System.out.println("Привіт, " + name + " " + surname + " з міста " + city + "! " + " Твій вік: " + age + " p.");
    }
}

