package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int abs = (n < 0) ? -n : n;

        System.out.println(abs);

        scanner.close();
    }
}
