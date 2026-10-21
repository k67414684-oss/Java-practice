package practice7;

public class Task22 {

    private int day;
    private int month;
    private int year;

    public Task22(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void add(int days) {
        add(days, 0, 0);
    }

    public void add(int days, int months) {
        add(days, months, 0);
    }

    public void add(int days, int months, int years) {
        day += days;
        month += months;
        year += years;
        while (day > 30) {
            day -= 30;
            month++;
        }
        while (month > 12) {
            month -= 12;
            year++;
        }
    }

    public void printDate() {
        System.out.println(String.format("%02d.%02d.%d", day, month, year));
    }

    public static void main(String[] args) {
        Task22 date = new Task22(15, 3, 2024);
        date.printDate();

        date.add(20);
        date.printDate();

        date.add(0, 3);
        date.printDate();

        date.add(10, 2, 1);
        date.printDate();
    }
}
