package practice6;

public class Task30 {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Помилка: некоректний вік " + age);
        }
    }

    public void printSummary() {
        System.out.println("Ім'я: " + name + ", вік: " + age);
    }

    public static void main(String[] args) {
        Task30 person1 = new Task30();
        person1.setName("Олена");
        person1.setAge(20);

        Task30 person2 = new Task30();
        person2.setName("Максим");
        person2.setAge(25);

        person1.printSummary();
        person2.printSummary();

        person2.setAge(150);
        person2.printSummary();
    }
}
