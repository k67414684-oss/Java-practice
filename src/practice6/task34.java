package practice6;

public class task34 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    mainDiagonalSum += matrix[i][j];
                }
                if (i + j == matrix.length - 1) {
                    antiDiagonalSum += matrix[i][j];
                }
            }
        }
        System.out.println("Головна діагональ: " + mainDiagonalSum);
        System.out.println("Побічна діагональ: " + antiDiagonalSum);
        if (mainDiagonalSum > antiDiagonalSum) {
            System.out.println("Головна діагональ більша");
        } else if (mainDiagonalSum < antiDiagonalSum) {
            System.out.println("Побічна діагональ більша");
        } else {
            System.out.println("Суми рівні");
        }
    }
}
