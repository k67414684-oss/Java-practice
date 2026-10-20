package practice5;

import java.util.Scanner;
import java.util.Random;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secret = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("Вгадайте число від 1 до 100:");
        while (true) {
            guess = scanner.nextInt();
            attempts++;
            if (guess > secret) {
                System.out.println("Менше!");
            } else if (guess < secret) {
                System.out.println("Більше!");
            } else {
                System.out.println("Ви вгадали! Кількість спроб: " + attempts);
                break;
            }
        }
        scanner.close();
    }
}