package practice6;

import java.util.Scanner;

public class task13 {
    public static void main(String[] args) {
        int[] rolls = {3, 6, 2, 6, 1, 4, 6, 5, 2, 6};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i] == target) {
                count++;
            }
        }
        System.out.println(count);
    }
}