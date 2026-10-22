package practice6;

public class Task35 {

    private double[] itemPrices = new double[10];
    private int count = 0;

    public void addItem(double price) {
        if (count < itemPrices.length) {
            itemPrices[count] = price;
            count++;
        } else {
            System.out.println("Кошик заповнений");
        }
    }

    public double getTotalCost() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public void applyDiscount(double percent) {
        for (int i = 0; i < count; i++) {
            itemPrices[i] = itemPrices[i] - itemPrices[i] * percent / 100;
        }
    }

    public void printReceipt() {
        System.out.println("----- Чек -----");
        for (int i = 0; i < count; i++) {
            System.out.println("Товар " + (i + 1) + ": " + itemPrices[i] + " грн");
        }
        System.out.println("Разом: " + getTotalCost() + " грн");
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        Task35 cart = new Task35();
        cart.addItem(120.5);
        cart.addItem(80.0);
        cart.addItem(250.0);

        cart.printReceipt();

        cart.applyDiscount(15);
        System.out.println("Після знижки 15%:");
        cart.printReceipt();
    }
}
