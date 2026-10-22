package practice6;

public class Task36 {

    private double[] dailyTemps = new double[7];

    public void setTemps(double[] temps) {
        dailyTemps = temps;
    }

    public int countDaysAbove(double threshold) {
        int count = 0;
        for (int i = 0; i < dailyTemps.length; i++) {
            if (dailyTemps[i] > threshold) {
                count++;
            }
        }
        return count;
    }

    public void printWeeklyReport() {
        int hottestDay = 0;
        for (int i = 0; i < dailyTemps.length; i++) {
            System.out.println("День " + (i + 1) + ": " + dailyTemps[i] + " °C");
            if (dailyTemps[i] > dailyTemps[hottestDay]) {
                hottestDay = i;
            }
        }
        System.out.println("Найтепліший день: день " + (hottestDay + 1) + " (" + dailyTemps[hottestDay] + " °C)");
    }

    public static void main(String[] args) {
        Task36 tracker = new Task36();
        double[] temps = {18.5, 21.0, 23.5, 19.0, 25.0, 22.5, 20.0};
        tracker.setTemps(temps);

        tracker.printWeeklyReport();
        System.out.println("Днів із температурою вище 20 °C: " + tracker.countDaysAbove(20));
    }
}
