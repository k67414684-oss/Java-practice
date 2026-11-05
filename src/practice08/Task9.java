package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task9 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task9: Employee -> Developer ---");
        Employee employee = new Employee("Ірина", 18000);
        Developer developer = new Developer("Polina", 20000, "Java");
        System.out.println(employee);
        System.out.println(developer);
    }

    static class Employee {
        private String name;
        protected double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = Math.max(0.0, salary);
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return String.format("Employee{name='%s', salary=%.2f}", name, salary);
        }
    }

    static class Developer extends Employee {
        private String programmingLanguage;

        public Developer(String name, double salary, String programmingLanguage) {
            super(name, salary);
            this.programmingLanguage = programmingLanguage;
        }

        public String getProgrammingLanguage() {
            return programmingLanguage;
        }

        @Override
        public String toString() {
            return String.format("Developer{%s, language='%s'}", super.toString(), programmingLanguage);
        }
    }
}
