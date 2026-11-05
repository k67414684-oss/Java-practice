package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task10 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task10: Animal -> Dog, Cat ---");
        Dog dog = new Dog("Рекс", 4, 28.5, "Німецька вівчарка");
        Cat cat = new Cat("Мурка", 2, 4.1, true);
        System.out.println(dog);
        System.out.println(dog.fetchStick());
        System.out.println(cat);
        System.out.println(cat.purr());
    }

    static class Animal {
        private String name;
        private int age;
        private double weight;

        public Animal(String name, int age, double weight) {
            this.name = name;
            this.age = Math.max(0, age);
            this.weight = weight > 0 ? weight : 1.0;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return String.format("Animal{name='%s', age=%d, weight=%.1f кг}", name, age, weight);
        }
    }

    static class Dog extends Animal {
        private String breed;

        public Dog(String name, int age, double weight, String breed) {
            super(name, age, weight);
            this.breed = breed;
        }

        public String getBreed() {
            return breed;
        }

        public String fetchStick() {
            return getName() + " (" + breed + ") біжить і приносить палицю!";
        }

        @Override
        public String toString() {
            return "Dog{" + super.toString() + ", breed='" + breed + "'}";
        }
    }

    static class Cat extends Animal {
        private boolean indoor;

        public Cat(String name, int age, double weight, boolean indoor) {
            super(name, age, weight);
            this.indoor = indoor;
        }

        public boolean isIndoor() {
            return indoor;
        }

        public String purr() {
            return getName() + ": мур-мур-мур...";
        }

        @Override
        public String toString() {
            return "Cat{" + super.toString() + ", indoor=" + indoor + "}";
        }
    }
}
