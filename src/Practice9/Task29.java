package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task29 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task29: AbstractTransaction ---");
        AbstractTransaction small = new DomesticTransfer("TX-1", 500);
        AbstractTransaction big = new DomesticTransfer("TX-2", 10000);
        AbstractTransaction crypto = new CryptoTransfer("TX-3", 2000, 12.5);
        System.out.println(small);
        System.out.println(big);
        System.out.println(crypto);
    }

    static abstract class AbstractTransaction {
        private final String txId;
        protected final double amount;

        public AbstractTransaction(String txId, double amount) {
            this.txId = txId;
            this.amount = Math.max(0.0, amount);
        }

        public abstract double calculateCommission();

        public final double getTotalDebit() {
            return amount + calculateCommission();
        }

        @Override
        public String toString() {
            return String.format("%s{%s, сума=%.2f, комісія=%.2f, до списання=%.2f}",
                    getClass().getSimpleName(), txId, amount, calculateCommission(), getTotalDebit());
        }
    }

    static class DomesticTransfer extends AbstractTransaction {

        public DomesticTransfer(String txId, double amount) {
            super(txId, amount);
        }

        @Override
        public double calculateCommission() {
            return Math.max(5.0, amount * 0.005);
        }
    }

    static class CryptoTransfer extends AbstractTransaction {
        private final double networkGasFee;

        public CryptoTransfer(String txId, double amount, double networkGasFee) {
            super(txId, amount);
            this.networkGasFee = Math.max(0.0, networkGasFee);
        }

        @Override
        public double calculateCommission() {
            return networkGasFee;
        }
    }
}
