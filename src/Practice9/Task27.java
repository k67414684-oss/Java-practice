package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task27 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task27: AbstractEmployee ---");
        AbstractEmployee salaried = new SalariedEmployee(1, "Олена", 40000, 5000);
        AbstractEmployee hourly = new HourlyContractor(2, "Максим", 180, 250);
        System.out.println(salaried);
        System.out.println(hourly);
    }

    static abstract class AbstractEmployee {
        private final int id;
        private final String name;
        protected double taxRate = 0.195;

        public AbstractEmployee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public abstract double calculateGrossSalary();

        public final double calculateNetSalary() {
            return calculateGrossSalary() * (1.0 - taxRate);
        }

        @Override
        public String toString() {
            return String.format("%s{id=%d, %s, брутто=%.2f, нетто=%.2f}",
                    getClass().getSimpleName(), id, name, calculateGrossSalary(), calculateNetSalary());
        }
    }

    static class SalariedEmployee extends AbstractEmployee {
        private final double monthlySalary;
        private final double bonus;

        public SalariedEmployee(int id, String name, double monthlySalary, double bonus) {
            super(id, name);
            this.monthlySalary = Math.max(0.0, monthlySalary);
            this.bonus = Math.max(0.0, bonus);
        }

        @Override
        public double calculateGrossSalary() {
            return monthlySalary + bonus;
        }
    }

    static class HourlyContractor extends AbstractEmployee {
        private final int hoursWorked;
        private final double hourlyRate;

        public HourlyContractor(int id, String name, int hoursWorked, double hourlyRate) {
            super(id, name);
            this.hoursWorked = Math.max(0, hoursWorked);
            this.hourlyRate = Math.max(0.0, hourlyRate);
        }

        @Override
        public double calculateGrossSalary() {
            int regular = Math.min(hoursWorked, 160);
            int overtime = Math.max(0, hoursWorked - 160);
            return regular * hourlyRate + overtime * hourlyRate * 1.5;
        }
    }
}
