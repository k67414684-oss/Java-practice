package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task4 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task4: CardWallet ---");
        CardWallet wallet = new CardWallet("1234567812344589", "4321", 12500);
        System.out.println(wallet);
        System.out.println("Зміна PIN зі старим 0000 -> " + wallet.changePin("0000", "1111"));
        System.out.println("Зміна PIN зі старим 4321 -> " + wallet.changePin("4321", "1111"));
        System.out.println(wallet);
    }

    static class CardWallet {
        private String cardNumber;
        private String pinCode;
        private double balance;

        public CardWallet(String cardNumber, String pinCode, double balance) {
            if (isValidCardNumber(cardNumber)) {
                this.cardNumber = cardNumber;
            } else {
                this.cardNumber = "0000000000000000";
            }
            if (isValidPin(pinCode)) {
                this.pinCode = pinCode;
            } else {
                this.pinCode = "0000";
            }
            this.balance = Math.max(0.0, balance);
        }

        private static boolean isValidCardNumber(String number) {
            return number != null && number.matches("\\d{16}");
        }

        private static boolean isValidPin(String pin) {
            return pin != null && pin.matches("\\d{4}");
        }

        public double getBalance() {
            return balance;
        }

        public boolean changePin(String oldPin, String newPin) {
            if (oldPin == null || !oldPin.equals(pinCode)) {
                return false;
            }
            if (!isValidPin(newPin)) {
                return false;
            }
            pinCode = newPin;
            return true;
        }

        private String getMaskedNumber() {
            return "**** **** **** " + cardNumber.substring(12);
        }

        @Override
        public String toString() {
            return String.format("CardWallet{card='%s', balance=%.2f UAH}", getMaskedNumber(), balance);
        }
    }
}
