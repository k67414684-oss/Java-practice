package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("[" + i + "] " + text);
        }

        scanner.close();
    }
}