package practice3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        System.out.print("Введіть перше число: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner .nextInt();

        System.out.print("Введіть друге число: ");
        int b = scanner .nextInt();

        System.out.println("Сума: " + (a + b));
        System.out.println("Різниця: " + (a - b));
        System.out.println("Добуток: " + (a * b));
        System.out.println("Остача від ділення: " + (a % b));


    }
}
