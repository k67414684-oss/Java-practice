package practice6;

public class Task21 {

    public double usdRate = 41.5;

    public double toUSD(double uah) {
        return uah / usdRate;
    }

    public double toUAH(double usd) {
        return usd * usdRate;
    }

    public static void main(String[] args) {
        Task21 exchange = new Task21();

        double dollars = exchange.toUSD(10000);
        System.out.println("10000 грн = " + String.format("%.2f", dollars) + " USD");

        double uah = exchange.toUAH(100);
        System.out.println("100 USD = " + String.format("%.2f", uah) + " грн");
    }
}
