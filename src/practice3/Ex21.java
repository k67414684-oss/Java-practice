package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String status = (n > 0) ? "Додатне" : (n < 0) ? "Від'ємне" : "Нуль";

        System.out.println(status);

        scanner.close();
    }
}
