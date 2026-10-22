package practice6;

public class Task8 {

    public String name;

    public static void main(String[] args) {
        Task8 first = new Task8();
        first.name = "Іван";

        Task8 second = first;
        second.name = "Петро";

        System.out.println("first.name = " + first.name);
        System.out.println("second.name = " + second.name);
        System.out.println("Змінна second не створює новий об'єкт, вона зберігає посилання на той самий об'єкт у купі, що й first.");
        System.out.println("Тому зміна імені через second змінює і first.");
    }
}
