package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task6 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task6: HighSecuritySafe ---");
        HighSecuritySafe safe = new HighSecuritySafe(4321, 10000);
        System.out.println("Покласти 500 з правильним PIN: " + safe.putCash(4321, 500));
        System.out.println("Взяти 200 з неправильним PIN:  " + safe.takeCash(1111, 200));
        System.out.println("Взяти 200 з неправильним PIN:  " + safe.takeCash(2222, 200));
        System.out.println("Взяти 200 з правильним PIN:    " + safe.takeCash(4321, 200));
        System.out.println("Три помилки підряд:");
        safe.takeCash(1, 1);
        safe.takeCash(2, 1);
        safe.takeCash(3, 1);
        System.out.println("Взяти 200 з правильним PIN після блокування: " + safe.takeCash(4321, 200));
        System.out.println(safe);
    }

    static class HighSecuritySafe {
        private final int pinCode;
        private double storedCash;
        private int failedAttempts;
        private boolean permanentlyBlocked;

        public HighSecuritySafe(int pinCode, double storedCash) {
            this.pinCode = pinCode;
            this.storedCash = Math.max(0.0, storedCash);
        }

        private boolean checkAccess(int enteredPin) {
            if (permanentlyBlocked) {
                return false;
            }
            if (enteredPin != pinCode) {
                failedAttempts++;
                if (failedAttempts >= 3) {
                    permanentlyBlocked = true;
                }
                return false;
            }
            failedAttempts = 0;
            return true;
        }

        public boolean putCash(int pin, double amount) {
            if (!checkAccess(pin) || amount <= 0) {
                return false;
            }
            storedCash += amount;
            return true;
        }

        public boolean takeCash(int pin, double amount) {
            if (!checkAccess(pin) || amount <= 0 || amount > storedCash) {
                return false;
            }
            storedCash -= amount;
            return true;
        }

        @Override
        public String toString() {
            return String.format("HighSecuritySafe{cash=%.2f, failedAttempts=%d, %s}",
                    storedCash, failedAttempts, permanentlyBlocked ? "НАЗАВЖДИ ЗАБЛОКОВАНО" : "активний");
        }
    }
}
