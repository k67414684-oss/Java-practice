package HomeWork10;

interface CashbackCapable {
    double MAX_CASHBACK_UAH = 500.0;
    double getCashbackRate();
    default double calculateCashback(double baseAmount) {
        return Math.min(MAX_CASHBACK_UAH, baseAmount * getCashbackRate());
    }
}

interface Refundable {
    boolean requestRefund(String reason);
    boolean isRefunded();
}

interface BlockchainVerifiable {
    String getTxHash();
    int getConfirmations();
    default boolean isFinalized() { return getConfirmations() >= 12; }
}

abstract class AbstractPaymentTransaction {
    private final String txId;
    private final double baseAmountUah;
    private boolean processed;

    public AbstractPaymentTransaction(String txId, double baseAmountUah) {
        this.txId = txId;
        this.baseAmountUah = baseAmountUah;
        this.processed = false;
    }

    public abstract double calculateFee();
    public abstract String getPaymentChannel();

    public final boolean process() {
        if (baseAmountUah <= 0 || processed) return false;
        processed = true;
        return true;
    }

    public final double getTotalCharged() { return baseAmountUah + calculateFee(); }
    public String getTxId() { return txId; }
    public double getBaseAmountUah() { return baseAmountUah; }
    public boolean isProcessed() { return processed; }
}

class PremiumCardPayment extends AbstractPaymentTransaction implements CashbackCapable, Refundable {
    private final String maskedPan;
    private boolean refunded = false;

    public PremiumCardPayment(String txId, double baseAmountUah, String maskedPan) {
        super(txId, baseAmountUah);
        this.maskedPan = maskedPan;
    }

    @Override public double calculateFee() { return getBaseAmountUah() * 0.01; }
    @Override public String getPaymentChannel() { return "Visa Infinite (" + maskedPan + ")"; }
    @Override public double getCashbackRate() { return 0.03; }
    @Override public boolean requestRefund(String reason) {
        if (isProcessed() && !refunded) { refunded = true; return true; }
        return false;
    }
    @Override public boolean isRefunded() { return refunded; }
}

class CryptoUsdtPayment extends AbstractPaymentTransaction implements CashbackCapable, BlockchainVerifiable {
    private final String txHash;
    private final int confirmations;

    public CryptoUsdtPayment(String txId, double baseAmountUah, String txHash, int confirmations) {
        super(txId, baseAmountUah);
        this.txHash = txHash;
        this.confirmations = confirmations;
    }

    @Override public double calculateFee() { return 40.0; }
    @Override public String getPaymentChannel() { return "USDT TRC-20"; }
    @Override public double getCashbackRate() { return 0.01; }
    @Override public String getTxHash() { return txHash; }
    @Override public int getConfirmations() { return confirmations; }
}

final class TaxTreasuryPayment extends AbstractPaymentTransaction implements Refundable {
    private final String taxCode;
    private boolean refunded = false;

    public TaxTreasuryPayment(String txId, double baseAmountUah, String taxCode) {
        super(txId, baseAmountUah);
        this.taxCode = taxCode;
    }

    @Override public double calculateFee() { return 0.0; }
    @Override public String getPaymentChannel() { return "ДержКазначейство (" + taxCode + ")"; }
    @Override public boolean requestRefund(String reason) {
        if (isProcessed() && !refunded) { refunded = true; return true; }
        return false;
    }
    @Override public boolean isRefunded() { return refunded; }
}

public class Ex2 {
    public static void auditLedger(AbstractPaymentTransaction[] ledger) {
        System.out.println("[1. ПРОВЕДЕННЯ ПАКЕТУ ТРАНЗАКЦІЙ (final process())]:");
        double totalTurnover = 0.0, totalFees = 0.0, totalCashback = 0.0;

        for (AbstractPaymentTransaction tx : ledger) {
            if (tx.process()) {
                totalTurnover += tx.getBaseAmountUah();
                totalFees += tx.calculateFee();
                System.out.printf("  ✅ [%-6s | %-28s] Сума: %8.2f грн | Комісія: %6.2f грн | Всього: %8.2f грн%n",
                        tx.getTxId(), tx.getPaymentChannel(), tx.getBaseAmountUah(), tx.calculateFee(), tx.getTotalCharged());
            }
        }

        System.out.println("\n[2. АВТОМАТИЧНИЙ АУДИТ МОЖЛИВОСТЕЙ (Pattern Matching instanceof)]:");
        for (AbstractPaymentTransaction tx : ledger) {
            if (tx instanceof CashbackCapable cb) {
                double raw = tx.getBaseAmountUah() * cb.getCashbackRate();
                double actual = cb.calculateCashback(tx.getBaseAmountUah());
                totalCashback += actual;
                if (raw > CashbackCapable.MAX_CASHBACK_UAH) {
                    System.out.printf("  💰 [CashbackCapable] %s: розрахунковий %.0f%% = %.0f грн -> нараховано %.2f грн (Ліміт MAX_CASHBACK_UAH!)%n",
                            tx.getTxId(), cb.getCashbackRate() * 100, raw, actual);
                } else {
                    System.out.printf("  💰 [CashbackCapable] %s: нараховано %.0f%% бонусу = %.2f грн%n",
                            tx.getTxId(), cb.getCashbackRate() * 100, actual);
                }
            }
            if (tx instanceof BlockchainVerifiable bv) {
                System.out.printf("  ⛓️ [BlockchainVerifiable] %s: Hash=%s, Підтверджень=%d (Finalized: %b)%n",
                        tx.getTxId(), bv.getTxHash(), bv.getConfirmations(), bv.isFinalized());
            }
            if (tx instanceof Refundable ref && tx.getTxId().equals("TX-101")) {
                boolean refunded = ref.requestRefund("Подвійне списання");
                System.out.printf("  🔄 [Refundable] Спроба повернення %s ('Подвійне списання'): %s%n",
                        tx.getTxId(), refunded ? "УСПІШНО ПОВЕРНЕНО!" : "ВІДХИЛЕНО");
            }
        }

        System.out.println("\n[ПІДСУМКОВИЙ ЗВІТ ШЛЮЗУ]:");
        System.out.printf("  Сумарний базовий оборот:  %.2f грн%n", totalTurnover);
        System.out.printf("  Сумарна комісія шлюзу:      %.2f грн%n", totalFees);
        System.out.printf("  Сумарний виплачений кешбек: %.2f грн%n", totalCashback);
    }

    public static void main(String[] args) {
        System.out.println("================ ДОМАШНЄ ЗАВДАННЯ 2 (Ex2): ПРОЦЕСИНГОВИЙ ЦЕНТР FINTECH ================");
        AbstractPaymentTransaction[] ledger = {
                new PremiumCardPayment("TX-101", 20000.0, "4149-xxxx-1234"),
                new CryptoUsdtPayment("TX-102", 8500.0, "0x9f8a...c4", 18),
                new TaxTreasuryPayment("TX-103", 5000.0, "11010100")
        };
        auditLedger(ledger);
    }
}
