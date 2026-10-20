package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число: ");
        int number = scanner.nextInt();

        if(number % 2 == 0) {
            System.out.println("Число парне");
        } else {
            System.out.println("Число непарне");

        }

    }
}