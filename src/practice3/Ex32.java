package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctPin = 1234;

        System.out.print("Введіть PIN-код: ");
        int enteredPin = scanner.nextInt();

        boolean isPinCorrect = (enteredPin == correctPin);

        boolean isCardActive = true;
        boolean hasSufficientBalance = true;
        boolean isDailyLimitExceeded = false;

        boolean isTransactionAllowed = isPinCorrect
                && isCardActive
                && hasSufficientBalance
                && !isDailyLimitExceeded;

        if (isTransactionAllowed) {
            System.out.println("Транзакція дозволена");
        } else {
            System.out.println("Транзакція відхилена");
        }

        scanner.close();
    }
}
