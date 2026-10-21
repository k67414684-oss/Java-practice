public class Task2NumberAnalysis {
    public static void main(String[] args) {


        //виділення чисел
        int number = 742;
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;


        //обчислення суми та добутку
        int a = hundreds + tens + units;
        int b = hundreds * tens * units;


        //реверс числа
        int reversNumber = units * 100 + tens * 10 + hundreds;


        //перевірка парності суми
        boolean c = a % 2 == 0;


        System.out.println("Початкове число:       " + number);
        System.out.println("Розряди:               " + "Сотні = " + hundreds + "  Десятки = " + tens + "  Одиниці = " + units);
        System.out.println("Сума цифр:             " + a);
        System.out.println("Добуток цифр:          " + b);
        System.out.println("Перевернуте число:     " + reversNumber);
        System.out.println("Чи є сума парною?:     " + c);

    }
}