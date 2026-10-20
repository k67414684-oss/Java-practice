package practice6;

public class task33 {
    public static void main(String[] args) {
        int[][] matrix = {
                {-5, 12, 3, 8},
                {20, -1, 4, 15},
                {7, 9, -10, 2}
        };
        int max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("Максимум: " + max + " у комірці [" + maxRow + ", " + maxCol + "]");
    }
}
