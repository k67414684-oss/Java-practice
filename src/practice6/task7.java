package practice6;

import java.util.Arrays;

public class task7 {
    public static void main(String[] args) {
        int[] original = {3, 7, 1, 9, 4};
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        copy[0] = 999;
        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(copy));
    }
}
