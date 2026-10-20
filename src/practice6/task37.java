package practice6;

public class task37 {
    public static void main(String[] args) {
        String[][] weekSchedule = {
                {"Вища математика", "Основи програмування", "Фізика"},
                {"Англійська мова", "Історія України"},
                {"Основи програмування", "Основи програмування", "Бази даних", "Фізвиховання"},
                {"Дискретна математика"},
                {"Філософія", "Основи алгоритмізації", "Практикум"}
        };
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця"};
        for (int i = 0; i < weekSchedule.length; i++) {
            System.out.println(days[i] + " (" + weekSchedule[i].length + " пар):");
            for (int j = 0; j < weekSchedule[i].length; j++) {
                System.out.println("  - " + weekSchedule[i][j]);
            }
        }
    }
}
