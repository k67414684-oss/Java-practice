package practice5;

import java.util.Random;

public class Ex {
    public static void main(String[] args) {
        Random random = new Random();
        int d1, d2;
        int attempts = 0;
        do {
            d1 = random.nextInt(6) + 1;
            d2 = random.nextInt(6) + 1;
            attempts++;
            System.out.println("Кидок " + attempts + ": " + d1 + " і " + d2);
        } while (d1 != d2);
        System.out.println("Випав дубль! Кількість спроб: " + attempts);
    }
}