package practice5;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        byte b = 125;
        for (int i = 0; i < 6; i++) {
            b = (byte) (b + 1);
            System.out.println(b);
        }
    }
}
