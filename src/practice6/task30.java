package practice6;

public class task30 {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 4, 6},
                {8, 10, 12},
                {14, 16, 18}
        };
        int sum = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                count++;
            }
        }
        double average = (double) sum / count;
        System.out.println("Загальна сума: " + sum);
        System.out.println("Кількість елементів: " + count);
        System.out.println("Середнє арифметичне: " + average);
    }
}
