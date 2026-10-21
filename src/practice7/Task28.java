package practice7;

public class Task28 {

    private static double usdToUahRate = 41.5;
    private static double eurToUahRate = 45.2;

    public static void updateRates(double newUsd, double newEur) {
        if (newUsd > 0) {
            usdToUahRate = newUsd;
        }
        if (newEur > 0) {
            eurToUahRate = newEur;
        }
    }

    public static double uahToUsd(double uah) {
        return uah / usdToUahRate;
    }

    public static double usdToUah(double usd) {
        return usd * usdToUahRate;
    }

    public static double eurToUah(double eur) {
        return eur * eurToUahRate;
    }

    public static void main(String[] args) {
        System.out.println("1000 грн у доларах: " + Task28.uahToUsd(1000));
        System.out.println("100 доларів у гривнях: " + Task28.usdToUah(100));
        System.out.println("100 євро у гривнях: " + Task28.eurToUah(100));

        Task28.updateRates(42.0, 46.5);
        System.out.println("Після оновлення курсу:");
        System.out.println("1000 грн у доларах: " + Task28.uahToUsd(1000));
        System.out.println("100 доларів у гривнях: " + Task28.usdToUah(100));
        System.out.println("100 євро у гривнях: " + Task28.eurToUah(100));
    }
}
