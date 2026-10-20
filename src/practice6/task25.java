package practice6;

public class task25 {
    public static void main(String[] args) {
        int[][] grid = new int[3][4];
        int counter = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = counter++;
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}