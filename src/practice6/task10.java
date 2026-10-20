package practice6;

public class task10 {
    public static void main(String[] args) {
        int[] data = {12, -5, 0, 43, -19, 0, -2, 8, 0, 15};
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                positiveCount++;
            } else if (data[i] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        System.out.println("Додатні: " + positiveCount);
        System.out.println("Від'ємні: " + negativeCount);
        System.out.println("Нулі: " + zeroCount);
    }
}