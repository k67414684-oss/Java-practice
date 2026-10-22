package practice6;

public class Task39 {

    private int[][] grid;

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void printMatrix() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int getTotalSum() {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }

    public int getRowSum(int rowIndex) {
        int sum = 0;
        for (int j = 0; j < grid[rowIndex].length; j++) {
            sum += grid[rowIndex][j];
        }
        return sum;
    }

    public static void main(String[] args) {
        Task39 matrix = new Task39();
        int[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        matrix.setGrid(numbers);

        matrix.printMatrix();
        System.out.println("Сума всіх елементів: " + matrix.getTotalSum());
        System.out.println("Сума 1-го рядка: " + matrix.getRowSum(0));
        System.out.println("Сума 2-го рядка: " + matrix.getRowSum(1));
        System.out.println("Сума 3-го рядка: " + matrix.getRowSum(2));
    }
}
