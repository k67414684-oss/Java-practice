package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task13 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task13: PlasticCard + BankAccount ---");
        BankAccount family = new BankAccount("UA213052990000026007233566001", 10000);
        PlasticCard dadCard = new PlasticCard("4149 4999 1111 2222", "11/28", family);
        PlasticCard momCard = new PlasticCard("5375 4141 3333 4444", "05/27", family);
        System.out.println("Тато платить 3000: " + dadCard.payAtTerminal(3000));
        System.out.println("Мама платить 2500: " + momCard.payAtTerminal(2500));
        System.out.println(family);
        momCard.block();
        System.out.println("Мама платить 100 (картка заблокована): " + momCard.payAtTerminal(100));
        System.out.println("Тато платить 9000 (не вистачає): " + dadCard.payAtTerminal(9000));
        System.out.println(dadCard);
        System.out.println(momCard);
    }

    static class BankAccount {
        private final String iban;
        private double balance;

        public BankAccount(String iban, double balance) {
            this.iban = iban;
            this.balance = Math.max(0.0, balance);
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
            return false;
        }

        public double getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return String.format("BankAccount{iban='%s', balance=%.2f}", iban, balance);
        }
    }

    static class PlasticCard {
        private final String cardNumber;
        private final String expiryDate;
        private boolean blocked;
        private final BankAccount linkedAccount;

        public PlasticCard(String cardNumber, String expiryDate, BankAccount linkedAccount) {
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.linkedAccount = linkedAccount;
        }

        public void block() {
            blocked = true;
        }

        public void unblock() {
            blocked = false;
        }

        public boolean payAtTerminal(double amount) {
            if (blocked) {
                return false;
            }
            return linkedAccount.withdraw(amount);
        }

        @Override
        public String toString() {
            return "PlasticCard{" + cardNumber + ", до " + expiryDate + ", " + (blocked ? "заблокована" : "активна")
                    + ", рахунок: " + linkedAccount + "}";
        }
    }
}
