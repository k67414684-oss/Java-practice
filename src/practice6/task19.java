package practice6;

import java.util.Arrays;

public class task19 {
    public static void main(String[] args) {
        int[] base = {2, 4, 6, 8, 10};
        int[] squares = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            squares[i] = base[i] * base[i];
        }
        System.out.println(Arrays.toString(base));
        System.out.println(Arrays.toString(squares));
    }
}
