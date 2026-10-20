package practice6;

import java.util.Arrays;

public class task6 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] * 2;
        }
        System.out.println(Arrays.toString(arr));
    }
}
