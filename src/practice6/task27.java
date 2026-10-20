package practice6;

public class task27 {
    public static void main(String[] args) {
        int[][] multTable = new int[9][9];
        for (int i = 0; i < multTable.length; i++) {
            for (int j = 0; j < multTable[i].length; j++) {
                multTable[i][j] = (i + 1) * (j + 1);
                System.out.print(multTable[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
