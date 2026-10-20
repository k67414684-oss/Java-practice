package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть години (0-23): ");
        int hours = scanner.nextInt();

        System.out.print("Введіть хвилини (0-59): ");
        int minutes = scanner.nextInt();

        boolean isValidTime = (hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59);

        if (isValidTime) {
            String hoursStr = (hours < 10) ? "0" + hours : "" + hours;
            String minutesStr = (minutes < 10) ? "0" + minutes : "" + minutes;

            System.out.println("Введений час: " + hoursStr + ":" + minutesStr);
        } else {
            System.out.println("Помилка: введено некоректний час!");
    }
    }
}
