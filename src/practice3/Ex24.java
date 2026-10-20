package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        String message = (count == 1)
                ? "Знайдено 1 помилку"
                : "Знайдено " + count + " помилок";

        System.out.println(message);

        scanner.close();
    }
}
