package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int power = 1;

        while (power <= m) {
            System.out.println(power);
            power *= 2;
        }

        scanner.close();
    }
}