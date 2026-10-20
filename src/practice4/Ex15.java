package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age;
        do {
            System.out.print("Введіть ваш вік: ");
            age = scanner.nextInt();
        } while (age < 1 || age > 120);
        System.out.println("Вік підтверджено: " + age);
        scanner.close();
    }
}