package practice6;

public class task14 {
    public static void main(String[] args) {
        int[] salaries = {18000, 25000, 32000, 15000, 41000, 29000};
        int sum = 0;
        for (int i = 0; i < salaries.length; i++) {
            sum += salaries[i];
        }
        double avg = (double) sum / salaries.length;
        for (int i = 0; i < salaries.length; i++) {
            if (salaries[i] > avg) {
                System.out.println(salaries[i]);
            }
        }
    }
}
