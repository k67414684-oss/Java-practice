package practice4;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            System.out.print("Виконано обчислення. Бажаєте продовжити? (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y');
        scanner.close();
    }
}