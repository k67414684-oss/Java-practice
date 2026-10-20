package practice6;

import java.util.Arrays;

public class task2 {
    public static void main(String[] args) {
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        System.out.println(days.length);
        System.out.println(days[0]);
        System.out.println(days[days.length - 1]);
        days[5] = "Вихідний (Сб)";
        days[6] = "Вихідний (Нд)";
        System.out.println(Arrays.toString(days));
    }
}
