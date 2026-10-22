package practice6;

public class Task16 {

    public String model;
    public int paperCount;

    public void printDocument(String title, int pages) {
        if (paperCount >= pages) {
            paperCount = paperCount - pages;
            System.out.println("Документ \"" + title + "\" (" + pages + " стор.) успішно надруковано. Залишилось паперу: " + paperCount);
        } else {
            System.out.println("Помилка: Недостатньо паперу в принтері " + model + "!");
        }
    }

    public static void main(String[] args) {
        Task16 printer = new Task16();
        printer.model = "HP LaserJet";
        printer.paperCount = 10;

        printer.printDocument("Звіт", 4);
        printer.printDocument("Книга", 20);
        printer.printDocument("Лист", 6);
        printer.printDocument("Ще один лист", 1);
    }
}
