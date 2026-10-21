package practice7;

public class Task1 {

    private String title;
    private String author;
    private int year;
    private double price;

    public Task1() {
        this.title = "Невідомо";
        this.author = "Невідомий";
        this.year = 2000;
        this.price = 0.0;
    }

    public Task1(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        if (year < 0 || price < 0.0) {
            this.year = 2000;
            this.price = 0.0;
        } else {
            this.year = year;
            this.price = price;
        }
    }

    public void printInfo() {
        System.out.println("Книга: " + title + ", автор: " + author + ", рік: " + year + ", ціна: " + price + " грн");
    }

    public static void main(String[] args) {
        Task1 book1 = new Task1();
        Task1 book2 = new Task1("Кобзар", "Тарас Шевченко", 1840, 250.0);
        Task1 book3 = new Task1("Погана книга", "Хтось", -5, 100.0);

        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
    }
}
