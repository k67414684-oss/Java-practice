package practice4;

public class Ex {
    public static void main(String[] args) {
        double[] prices = {19.99, 45.50, 12.10, 99.95, 3.40};
        int totalInteger = 0;
        double totalCoins = 0;
        for (double price : prices) {
            int integerPart = (int) price;
            totalInteger += integerPart;
            totalCoins += (price - integerPart);
        }
        System.out.println("Загальна сума цілих гривень: " + totalInteger);
        System.out.printf("Сума відкинутих копійок: %.2f\n", totalCoins);
    }
}
