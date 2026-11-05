package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task18 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task18: StandardTransfer -> InternationalTransfer ---");
        StandardTransfer standard = new StandardTransfer(1000);
        InternationalTransfer international = new InternationalTransfer(1000, "PL");
        System.out.println(standard);
        System.out.println(international);
    }

    static class StandardTransfer {
        protected double amount;

        public StandardTransfer(double amount) {
            this.amount = Math.max(0.0, amount);
        }

        public double getFee() {
            return amount * 0.01;
        }

        public double getTotalWithFee() {
            return amount + getFee();
        }

        @Override
        public String toString() {
            return String.format("StandardTransfer{amount=%.2f, fee=%.2f, total=%.2f}", amount, getFee(), getTotalWithFee());
        }
    }

    static class InternationalTransfer extends StandardTransfer {
        private String countryCode;
        private static final double SWIFT_FEE = 15.0;

        public InternationalTransfer(double amount, String countryCode) {
            super(amount);
            this.countryCode = countryCode;
        }

        @Override
        public double getFee() {
            return super.getFee() * 2 + SWIFT_FEE;
        }

        @Override
        public String toString() {
            return String.format("InternationalTransfer{country=%s, amount=%.2f, fee=%.2f (2%% + %.0f SWIFT), total=%.2f}",
                    countryCode, amount, getFee(), SWIFT_FEE, getTotalWithFee());
        }
    }
}
