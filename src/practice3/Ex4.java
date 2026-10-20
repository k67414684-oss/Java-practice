package practice3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер квитка: ");
        int numberTicket = scanner.nextInt();

        System.out.print("Введіть повне ім'я студента: ");
        String fullName = scanner.next();

        System.out.print("Введіть спеціальність: ");
        String specialty = scanner.next();

        System.out.println("=======================================");

        System.out.println("Студент: ," + fullName + " №" + numberTicket + "," );
        System.out.print("спеціальність: " + specialty);



    }
}
