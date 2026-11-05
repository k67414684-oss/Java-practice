package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task17 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task17: StaffMember -> Manager, SalesPerson ---");
        StaffMember staff = new StaffMember("Андрій", 15000);
        Manager manager = new Manager("Ольга", 25000, 8000);
        SalesPerson seller = new SalesPerson("Дмитро", 12000, 200000, 5);
        System.out.println(staff);
        System.out.println(manager);
        System.out.println(seller);
    }

    static class StaffMember {
        private String name;
        private double baseSalary;

        public StaffMember(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = Math.max(0.0, baseSalary);
        }

        public String getName() {
            return name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public double calculateMonthlyPay() {
            return baseSalary;
        }

        @Override
        public String toString() {
            return String.format("StaffMember{name='%s', base=%.2f, pay=%.2f}", name, baseSalary, calculateMonthlyPay());
        }
    }

    static class Manager extends StaffMember {
        private double teamBonus;

        public Manager(String name, double baseSalary, double teamBonus) {
            super(name, baseSalary);
            this.teamBonus = Math.max(0.0, teamBonus);
        }

        @Override
        public double calculateMonthlyPay() {
            return super.calculateMonthlyPay() + teamBonus;
        }

        @Override
        public String toString() {
            return String.format("Manager{name='%s', base=%.2f, teamBonus=%.2f, pay=%.2f}",
                    getName(), getBaseSalary(), teamBonus, calculateMonthlyPay());
        }
    }

    static class SalesPerson extends StaffMember {
        private double salesVolume;
        private double commissionRate;

        public SalesPerson(String name, double baseSalary, double salesVolume, double commissionRate) {
            super(name, baseSalary);
            this.salesVolume = Math.max(0.0, salesVolume);
            this.commissionRate = Math.max(0.0, commissionRate);
        }

        @Override
        public double calculateMonthlyPay() {
            return super.calculateMonthlyPay() + salesVolume * (commissionRate / 100.0);
        }

        @Override
        public String toString() {
            return String.format("SalesPerson{name='%s', base=%.2f, sales=%.2f, commission=%.1f%%, pay=%.2f}",
                    getName(), getBaseSalary(), salesVolume, commissionRate, calculateMonthlyPay());
        }
    }
}
