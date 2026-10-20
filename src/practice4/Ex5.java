package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int w = scanner.nextInt();

        for (int i = 0; i < w; i++) {
            System.out.print("=");
        }

        System.out.println();

        scanner.close();
    }
}