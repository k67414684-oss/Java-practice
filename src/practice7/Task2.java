package practice7;

public class Task2 {

    private String name;
    private int age;
    private double gpa;

    public Task2(String name, int age, double gpa) {
        this.name = name;
        if (age < 15 || age > 80) {
            this.age = 18;
        } else {
            this.age = age;
        }
        if (gpa < 0.0 || gpa > 5.0) {
            this.gpa = 0.0;
        } else {
            this.gpa = gpa;
        }
    }

    public boolean isHonorStudent() {
        return gpa >= 4.5;
    }

    public void printStudent() {
        String status;
        if (isHonorStudent()) {
            status = "Відмінник";
        } else {
            status = "Звичайний студент";
        }
        System.out.println("Студент: " + name + ", вік: " + age + ", середній бал: " + gpa + ", статус: " + status);
    }

    public static void main(String[] args) {
        Task2 s1 = new Task2("Олена", 19, 4.8);
        Task2 s2 = new Task2("Максим", 20, 3.7);
        Task2 s3 = new Task2("Іван", 5, 7.5);
        Task2 s4 = new Task2("Ірина", 100, -1.0);

        s1.printStudent();
        s2.printStudent();
        s3.printStudent();
        s4.printStudent();
    }
}
