package practice5;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a1 = scanner.nextDouble();
        double d = scanner.nextDouble();
        int n = scanner.nextInt();
        double sum = 0;
        double current = a1;
        for (int i = 0; i < n; i++) {
            System.out.print(current + " ");
            sum += current;
            current += d;
        }
        System.out.println("\nСума прогресії: " + sum);
        scanner.close();
        }
    }
