package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int count = 0;
        int score;

        System.out.println("Вводьте бали (від 0 до 100). Від'ємне число для виходу:");
        while (true) {
            do {
                score = scanner.nextInt();
                if (score < 0) {
                    break;
                }
                if (score > 100) {
                    System.out.println("Некоректний бал, повторіть введення:");
                }
            } while (score > 100);

            if (score < 0) {
                break;
            }
            sum += score;
            count++;
        }

        if (count > 0) {
            System.out.println("Середній бал: " + (sum / count));
        } else {
            System.out.println("Жодного балу не введено.");
        }
        scanner.close();
    }
}