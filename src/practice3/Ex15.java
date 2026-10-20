package practice3;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 5;
        int y = 20;

        if (x > 10) {
            if (y > 10) {
                System.out.println("y більше 10");
            }
        } else {
            System.out.println("x менше або дорівнює 10");
        }
    }
}
