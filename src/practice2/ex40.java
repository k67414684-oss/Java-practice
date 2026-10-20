public class ііі {
    public static void main(String[] args) {

        double P = 10000.0;
        double r = 12.0;
        int t = 3;

        double S = P * Math.pow(1 + r / 100, t);
        double profit = S - P;

        System.out.println("+---------------------------------+");
        System.out.println("|      ДЕПОЗИТНИЙ КАЛЬКУЛЯТОР     |");
        System.out.println("+---------------------------------+");
        System.out.printf("Початкова сума: %.1f грн%n", P);
        System.out.printf("Термін: %d роки під %.1f%% річних%n", t, r);
        System.out.printf("Підсумкова сума: %.2f грн%n", S);
        System.out.printf("Чистий прибуток: %.2f грн%n", profit);
        System.out.println("+---------------------------------+");
    }
}
