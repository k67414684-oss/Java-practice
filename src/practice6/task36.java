package practice6;

public class task36 {
    public static void main(String[] args) {
        int[][] ladder = new int[4][];
        ladder[0] = new int[1];
        ladder[1] = new int[2];
        ladder[2] = new int[3];
        ladder[3] = new int[4];
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                ladder[i][j] = i;
                System.out.print(ladder[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
