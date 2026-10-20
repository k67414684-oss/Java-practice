package practice6;

public class task15 {
    public static void main(String[] args) {
        double[] prices = {42.5, 41.8, 44.1, 40.9, 43.6, 45.0};
        double min = prices[0];
        double max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        double diff = max - min;
        System.out.printf("%.2f\n", diff);
    }
}
