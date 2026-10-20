package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть X: ");
        double x = scanner.nextDouble();

        System.out.print("Введіть Y: ");
        double y = scanner.nextDouble();

        if (x == 0 && y == 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться в початку координат.");
        } else if (x == 0) {
            System.out.println("Точка (" + x + "; " + y + ") лежит на осі Y.");
        } else if (y == 0) {
            System.out.println("Точка (" + x + "; " + y + ") лежит на осі X.");
        } else if (x > 0 && y > 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у I чверті.");
        } else if (x < 0 && y > 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у II чверті.");
        } else if (x < 0 && y < 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у III чверті.");
        } else {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у IV чверті.");
        }
    }
}