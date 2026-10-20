package practice6;

public class task11 {
    public static void main(String[] args) {
        int[] arr = {12, 5, 7, 8, 3, 10, 4, 9, 2, 11};
        int evenCount = 0;
        int oddSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddSum += arr[i];
            }
        }
        System.out.println("Кількість парних чисел: " + evenCount);
        System.out.println("Сума непарних чисел: " + oddSum);
    }
}
