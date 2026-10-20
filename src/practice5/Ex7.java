package practice5;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int number;

        while ((number = scanner.nextInt()) != 0) {
            sum += number;
        }

        System.out.println(sum);
        scanner.close();
    }
}