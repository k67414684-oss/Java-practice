package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        boolean isEvenBitwise = (n & 1) == 0;

        boolean isEvenMod = n % 2 == 0;

        System.out.println("isEvenBitwise: " + isEvenBitwise);
        System.out.println("isEvenMod: " + isEvenMod);

        scanner.close();
    }
}
