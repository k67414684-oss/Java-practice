package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task36 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task36: InvestmentPortfolio ---");
        InvestmentPortfolio portfolio = new InvestmentPortfolio("Влад", 5);
        portfolio.addAsset(new GovernmentBond("ОВДП-2027", 100000));
        portfolio.addAsset(new DividendStock("AAPL", 50000, 8.0, 1.5));
        portfolio.addAsset(new DividendStock("KO", 30000, 4.0, 3.1));
        System.out.println(portfolio);
    }

    static abstract class AbstractAsset {
        private final String ticker;
        protected double investedAmount;

        public AbstractAsset(String ticker, double investedAmount) {
            this.ticker = ticker;
            this.investedAmount = Math.max(0.0, investedAmount);
        }

        public double getInvestedAmount() {
            return investedAmount;
        }

        public abstract double calculateAnnualReturn();

        @Override
        public String toString() {
            return String.format("%s{%s, вкладено %.2f, річний дохід %.2f}", getClass().getSimpleName(), ticker,
                    investedAmount, calculateAnnualReturn());
        }
    }

    static class GovernmentBond extends AbstractAsset {
        private static final double COUPON = 0.155;

        public GovernmentBond(String ticker, double investedAmount) {
            super(ticker, investedAmount);
        }

        @Override
        public double calculateAnnualReturn() {
            return investedAmount * COUPON;
        }
    }

    static class DividendStock extends AbstractAsset {
        private static final double DIVIDEND_TAX = 0.195;
        private final double expectedGrowthPercent;
        private final double dividendYieldPercent;

        public DividendStock(String ticker, double investedAmount, double expectedGrowthPercent, double dividendYieldPercent) {
            super(ticker, investedAmount);
            this.expectedGrowthPercent = expectedGrowthPercent;
            this.dividendYieldPercent = Math.max(0.0, dividendYieldPercent);
        }

        @Override
        public double calculateAnnualReturn() {
            double growth = investedAmount * expectedGrowthPercent / 100.0;
            double dividends = investedAmount * dividendYieldPercent / 100.0 * (1 - DIVIDEND_TAX);
            return growth + dividends;
        }
    }

    static class InvestmentPortfolio {
        private final String investorName;
        private final AbstractAsset[] assets;
        private int assetCount;

        public InvestmentPortfolio(String investorName, int capacity) {
            this.investorName = investorName;
            this.assets = new AbstractAsset[Math.max(1, capacity)];
        }

        public boolean addAsset(AbstractAsset asset) {
            if (asset == null || assetCount >= assets.length) {
                return false;
            }
            assets[assetCount++] = asset;
            return true;
        }

        public double getTotalValue() {
            double total = 0;
            for (int i = 0; i < assetCount; i++) {
                total += assets[i].getInvestedAmount();
            }
            return total;
        }

        public double getExpectedAnnualReturn() {
            double total = 0;
            for (int i = 0; i < assetCount; i++) {
                total += assets[i].calculateAnnualReturn();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Портфель інвестора " + investorName + ":");
            for (int i = 0; i < assetCount; i++) {
                sb.append("\n  ").append(assets[i]);
            }
            sb.append(String.format("%n  Вартість портфеля: %.2f, очікуваний річний прибуток: %.2f (%.2f%%)",
                    getTotalValue(), getExpectedAnnualReturn(), getExpectedAnnualReturn() / getTotalValue() * 100));
            return sb.toString();
        }
    }
}
