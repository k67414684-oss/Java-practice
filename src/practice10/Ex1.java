package practice10;

abstract class PaymentInstrument {
    private final String payerName;
    public PaymentInstrument(String payerName) { this.payerName = payerName; }
    public String getPayerName() { return payerName; }
    public abstract double calculateFee(double amount);
    public double processPayment(double amount) { return amount + calculateFee(amount); }
}

class BankCardInstrument extends PaymentInstrument {
    public BankCardInstrument(String payerName) { super(payerName); }
    @Override public double calculateFee(double amount) { return amount * 0.015 + 5.0; }
}

class CryptoTokenInstrument extends PaymentInstrument {
    private final double gasFeeUah;
    public CryptoTokenInstrument(String payerName, double gasFeeUah) { super(payerName); this.gasFeeUah = gasFeeUah; }
    @Override public double calculateFee(double amount) { return gasFeeUah; }
}

class IbanDirectInstrument extends PaymentInstrument {
    public IbanDirectInstrument(String payerName) { super(payerName); }
    @Override public double calculateFee(double amount) { return amount <= 50_000.0 ? 0.0 : amount * 0.005; }
}

public class Ex1 {
    public static void main(String[] args) {
        PaymentInstrument[] payments = {
                new BankCardInstrument("Іван"),
                new CryptoTokenInstrument("Олена", 45.0),
                new IbanDirectInstrument("Максим")
        };
        double total = 0;
        for (PaymentInstrument p : payments) {
            double cost = p.processPayment(10_000.0);
            total += cost;
            System.out.printf("%s (%s): до сплати %.2f грн%n", p.getPayerName(), p.getClass().getSimpleName(), cost);
        }
        System.out.printf("Сумарні витрати на всі 3 платежі: %.2f грн%n", total);
    }
}
