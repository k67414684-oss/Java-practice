package practice6;

import java.util.Scanner;

public class task12 {
    public static void main(String[] args) {
        int[] students = {1042, 2031, 3055, 4018, 5099};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == target) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println("Студента з таким номером не знайдено");
        }
    }
}
