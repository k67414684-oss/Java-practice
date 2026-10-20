package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть символ: ");

        char ch = scanner.next().charAt(0);

        int code = (int) ch;

        System.out.println("Символ: " + ch + " | Код символу: " + code);

        scanner.close();
    }
}