package practice6;

public class Task40 {

    private int[][] matrix;

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getMainDiagonalSum() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public int getAntiDiagonalSum() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    public boolean isDiagonalSymmetric() {
        return getMainDiagonalSum() == getAntiDiagonalSum();
    }

    public static void main(String[] args) {
        Task40 diagonals = new Task40();
        int[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        diagonals.setMatrix(numbers);

        System.out.println("Сума головної діагоналі: " + diagonals.getMainDiagonalSum());
        System.out.println("Сума побічної діагоналі: " + diagonals.getAntiDiagonalSum());
        System.out.println("Діагоналі симетричні: " + diagonals.isDiagonalSymmetric());
    }
}
