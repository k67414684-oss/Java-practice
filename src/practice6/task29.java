package practice6;

public class task29 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 1;
            }
        }
        for (int j = 0; j < matrix[1].length; j++) {
            matrix[1][j] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][2] = 7;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
