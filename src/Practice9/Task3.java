package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task3 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task3: CryptoVault ---");
        CryptoVault vault = new CryptoVault("bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh", "alpha beta gamma", 1.25);
        System.out.println(vault);
        System.out.println("Відправка при заблокованому гаманці: " + vault.sendBtc(0.1, "bc1qdest"));
        System.out.println("Розблокування з неправильною фразою: " + vault.unlock("wrong"));
        System.out.println("Розблокування з правильною фразою:   " + vault.unlock("alpha beta gamma"));
        System.out.println("Відправка 0.5 BTC: " + vault.sendBtc(0.5, "bc1qdest"));
        System.out.println("Відправка 5 BTC:   " + vault.sendBtc(5, "bc1qdest"));
        vault.lock();
        System.out.println(vault);
    }

    static class CryptoVault {
        private final String walletAddress;
        private final String secretRecoveryPhrase;
        private double btcBalance;
        private boolean locked;

        public CryptoVault(String walletAddress, String secretRecoveryPhrase, double btcBalance) {
            this.walletAddress = walletAddress;
            this.secretRecoveryPhrase = secretRecoveryPhrase;
            this.btcBalance = Math.max(0.0, btcBalance);
            this.locked = true;
        }

        public boolean unlock(String phrase) {
            if (phrase != null && phrase.equals(secretRecoveryPhrase)) {
                locked = false;
                return true;
            }
            return false;
        }

        public void lock() {
            locked = true;
        }

        public boolean sendBtc(double amount, String destination) {
            if (locked || amount <= 0 || btcBalance < amount || destination == null || destination.isBlank()) {
                return false;
            }
            btcBalance -= amount;
            return true;
        }

        @Override
        public String toString() {
            return String.format("CryptoVault{address='%s', %s, balance=%.4f BTC}",
                    walletAddress, locked ? "ЗАБЛОКОВАНО" : "розблоковано", btcBalance);
        }
    }
}
