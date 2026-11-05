package HomeWork8;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task2 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("================ БАНКІВСЬКА ІЄРАРХІЯ РАХУНКІВ ================");

        SavingsAccount savings = new SavingsAccount("UA101", "Олена Коваль", 5000.0, 12.0, 1000.0);
        System.out.println("1. Ощадний рахунок (початковий стан):");
        System.out.println(savings);

        System.out.print("-> Спроба зняти 4500 грн: ");
        savings.withdraw(4500);

        System.out.println("-> Нарахування річних відсотків (+12%)...");
        savings.applyInterest();
        System.out.println(savings);

        System.out.print("-> Спроба зняти 1000 грн: ");
        if (savings.withdraw(1000)) {
            System.out.println("УСПІШНО!");
        }
        System.out.println(savings);

        System.out.println();
        CreditAccount credit = new CreditAccount("UA202", "Максим Бондар", 2000.0, 10000.0, 2.0);
        System.out.println("2. Кредитний рахунок (початковий стан):");
        System.out.println(credit);

        System.out.print("-> Покупка на 5000 грн (3000 грн у кредит з комісією 2% = 60 грн)... ");
        if (credit.withdraw(5000)) {
            System.out.println("УСПІШНО!");
        }
        System.out.println(credit);

        System.out.print("-> Покупка на 8000 грн (понад ліміт)... ");
        if (credit.withdraw(8000)) {
            System.out.println("УСПІШНО!");
        }

        credit.deposit(10000);
        System.out.println("-> Поповнення на 10000 грн:");
        System.out.println(credit);
        System.out.print("-> Зняття 1000 грн (власні кошти, без комісії)... ");
        if (credit.withdraw(1000)) {
            System.out.println("УСПІШНО!");
        }
        System.out.println(credit);

        System.out.println();
        BankAccount simple = new BankAccount("UA303", "Ірина Мельник", 300.0);
        System.out.println("3. Звичайний рахунок:");
        System.out.println(simple);
        System.out.print("-> Спроба зняти 500 грн: ");
        simple.withdraw(500);
        System.out.println("==============================================================");
    }
    static class BankAccount {
        private String iban;
        private String ownerName;
        protected double balance;

        public BankAccount(String iban, String ownerName, double initialBalance) {
            this.iban = iban;
            this.ownerName = ownerName;
            this.balance = initialBalance < 0 ? 0.0 : initialBalance;
        }

        public String getIban() {
            return iban;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            System.out.println("ВІДМОВА (недостатньо коштів або некоректна сума)");
            return false;
        }

        @Override
        public String toString() {
            return String.format("Рахунок[%s | Власник: %s | Баланс: %.2f грн]", iban, ownerName, balance);
        }
    }

    static class CreditAccount extends BankAccount {
        private double creditLimit;
        private double feePercent;

        public CreditAccount(String iban, String ownerName, double initialBalance,
                             double creditLimit, double feePercent) {
            super(iban, ownerName, initialBalance);
            this.creditLimit = Math.max(0.0, creditLimit);
            this.feePercent = Math.max(0.0, feePercent);
        }

        public double getCreditLimit() {
            return creditLimit;
        }

        @Override
        public boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("ВІДМОВА (некоректна сума)");
                return false;
            }

            if (balance >= amount) {
                return super.withdraw(amount);
            }

            double borrowed = amount - Math.max(0.0, balance);
            double fee = borrowed * (feePercent / 100.0);
            double newBalance = balance - amount - fee;

            if (newBalance >= -creditLimit) {
                this.balance = newBalance;
                return true;
            }
            System.out.printf("ВІДМОВА (перевищено кредитний ліміт %.2f грн)%n", creditLimit);
            return false;
        }

        public double getCurrentDebt() {
            return balance < 0 ? Math.abs(balance) : 0.0;
        }

        @Override
        public String toString() {
            return String.format("CreditAccount{%s, Ліміт: %.2f грн, Борг: %.2f грн}",
                    super.toString(), creditLimit, getCurrentDebt());
        }
    }

    static class SavingsAccount extends BankAccount {
        private double interestRate;
        private double minBalance;

        public SavingsAccount(String iban, String ownerName, double initialBalance,
                              double interestRate, double minBalance) {
            super(iban, ownerName, initialBalance);
            this.interestRate = Math.max(0.0, interestRate);
            this.minBalance = Math.max(0.0, minBalance);
        }

        public double getInterestRate() {
            return interestRate;
        }

        public double getMinBalance() {
            return minBalance;
        }

        @Override
        public boolean withdraw(double amount) {

            if (balance - amount >= minBalance) {
                return super.withdraw(amount);
            }
            System.out.printf("ВІДМОВА (порушення незнижуваного залишку %.2f грн)%n", minBalance);
            return false;
        }

        public void applyInterest() {
            double interest = balance * (interestRate / 100.0);
            deposit(interest);
        }

        @Override
        public String toString() {
            return String.format("SavingsAccount{%s, Ставка: %.1f%%, Мін.залишок: %.2f грн}",
                    super.toString(), interestRate, minBalance);
        }
    }
}
