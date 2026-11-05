package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task27 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task27: PaymentCard -> DebitCard -> CashbackPlatinumCard ---");
        CashbackPlatinumCard card = new CashbackPlatinumCard("Влад", 10000, 5000, 3);
        System.out.println(card);
        System.out.println("Оплата 1200: " + card.pay(1200));
        System.out.println("Оплата 6000 (понад ліміт): " + card.pay(6000));
        System.out.println("Оплата 4000: " + card.pay(4000));
        System.out.println("Ще одна оплата 4000: " + card.pay(4000));
        System.out.println("Оплата 4000 (на картці лишилось мало): " + card.pay(4000));
        System.out.println(card);
    }

    static class PaymentCard {
        private String cardHolder;
        protected double balance;

        public PaymentCard(String cardHolder, double balance) {
            this.cardHolder = cardHolder;
            this.balance = Math.max(0.0, balance);
        }

        public String getCardHolder() {
            return cardHolder;
        }

        public double getBalance() {
            return balance;
        }

        public boolean pay(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return String.format("PaymentCard{holder='%s', balance=%.2f}", cardHolder, balance);
        }
    }

    static class DebitCard extends PaymentCard {
        private double dailyLimit;

        public DebitCard(String cardHolder, double balance, double dailyLimit) {
            super(cardHolder, balance);
            this.dailyLimit = Math.max(0.0, dailyLimit);
        }

        public double getDailyLimit() {
            return dailyLimit;
        }

        @Override
        public boolean pay(double amount) {
            if (amount > dailyLimit) {
                return false;
            }
            return super.pay(amount);
        }

        @Override
        public String toString() {
            return String.format("DebitCard{%s, dailyLimit=%.2f}", super.toString(), dailyLimit);
        }
    }

    static class CashbackPlatinumCard extends DebitCard {
        private double cashbackPercent;
        private double accumulatedCashback;

        public CashbackPlatinumCard(String cardHolder, double balance, double dailyLimit, double cashbackPercent) {
            super(cardHolder, balance, dailyLimit);
            this.cashbackPercent = Math.max(0.0, cashbackPercent);
            this.accumulatedCashback = 0.0;
        }

        public double getAccumulatedCashback() {
            return accumulatedCashback;
        }

        @Override
        public boolean pay(double amount) {
            boolean success = super.pay(amount);
            if (success) {
                accumulatedCashback += amount * cashbackPercent / 100.0;
            }
            return success;
        }

        @Override
        public String toString() {
            return String.format("CashbackPlatinumCard{%s, cashback=%.1f%%, накопичено=%.2f}",
                    super.toString(), cashbackPercent, accumulatedCashback);
        }
    }
}
