package practice10;

abstract class AbstractFinancialInstrument {
    private final String ticker;
    protected int quantity;
    public AbstractFinancialInstrument(String ticker, int quantity) { this.ticker = ticker; this.quantity = quantity; }
    public String getTicker() { return ticker; }
    public abstract double getMarketValueUah();
}
interface Tradable { boolean buy(int qty); boolean sell(int qty); }
interface DividendPaying { double calculateAnnualDividend(); }

class TechGrowthStock extends AbstractFinancialInstrument implements Tradable {
    private final double price;
    public TechGrowthStock(String ticker, int qty, double price) { super(ticker, qty); this.price = price; }
    @Override public double getMarketValueUah() { return quantity * price; }
    @Override public boolean buy(int qty) { if (qty > 0) { quantity += qty; return true; } return false; }
    @Override public boolean sell(int qty) { if (qty > 0 && quantity >= qty) { quantity -= qty; return true; } return false; }
}
class BlueChipStock extends TechGrowthStock implements DividendPaying {
    private final double divYield;
    public BlueChipStock(String ticker, int qty, double price, double divYield) { super(ticker, qty, price); this.divYield = divYield; }
    @Override public double calculateAnnualDividend() { return getMarketValueUah() * divYield; }
}
class FixedTermDeposit extends AbstractFinancialInstrument implements DividendPaying {
    private final double amount, rate;
    public FixedTermDeposit(String ticker, double amount, double rate) { super(ticker, 1); this.amount = amount; this.rate = rate; }
    @Override public double getMarketValueUah() { return amount; }
    @Override public double calculateAnnualDividend() { return amount * rate; }
}

public class Ex19 {
    public static void main(String[] args) {
        AbstractFinancialInstrument[] portfolio = {
                new TechGrowthStock("NVDA", 5, 5000),
                new BlueChipStock("MSFT", 10, 16000, 0.02),
                new FixedTermDeposit("UAH-DEP", 100000, 0.14)
        };
        double val = 0, div = 0;
        for (AbstractFinancialInstrument fi : portfolio) {
            val += fi.getMarketValueUah();
            if (fi instanceof DividendPaying dp) div += dp.calculateAnnualDividend();
        }
        System.out.printf("Портфель: %.2f грн | Річні дивіденди/відсотки: %.2f грн%n", val, div);
    }
}
