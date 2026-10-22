package practice6;

public class Task15 {

    public int seconds;

    public void tick() {
        seconds++;
    }

    public void addSeconds(int s) {
        seconds = seconds + s;
    }

    public void displayTime() {
        int minutes = seconds / 60;
        int sec = seconds % 60;
        System.out.println(String.format("%02d:%02d", minutes, sec));
    }

    public static void main(String[] args) {
        Task15 stopwatch = new Task15();
        stopwatch.displayTime();

        stopwatch.tick();
        stopwatch.displayTime();

        stopwatch.addSeconds(124);
        stopwatch.displayTime();

        stopwatch.addSeconds(3600);
        stopwatch.displayTime();
    }
}
