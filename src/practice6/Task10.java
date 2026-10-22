package practice6;

public class Task10 {

    public String species;
    public String name;

    public void makeSound() {
        System.out.println(name + " видає звук!");
    }

    public void printInfo() {
        System.out.println("Вид: " + species + ", кличка: " + name);
    }

    public static void main(String[] args) {
        Task10 cat = new Task10();
        cat.species = "Кіт";
        cat.name = "Мурзик";

        Task10 dog = new Task10();
        dog.species = "Собака";
        dog.name = "Рекс";

        cat.printInfo();
        cat.makeSound();
        dog.printInfo();
        dog.makeSound();
    }
}
