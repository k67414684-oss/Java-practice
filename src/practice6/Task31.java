package practice6;

public class Task31 {

    private String ownerName;
    private double totalSpent;
    private int discountPercent;

    public Task31(String ownerName) {
        this.ownerName = ownerName;
        this.totalSpent = 0.0;
        this.discountPercent = 1;
    }

    public void addPurchase(double cost) {
        totalSpent += cost;
        if (totalSpent >= 10000) {
            discountPercent = 10;
        } else if (totalSpent >= 5000) {
            discountPercent = 5;
        } else {
            discountPercent = 1;
        }
    }

    public void printCardInfo() {
        System.out.println("Власник: " + ownerName + ", витрачено: " + totalSpent + " грн, знижка: " + discountPercent + "%");
    }

    public static void main(String[] args) {
        Task31 card = new Task31("Олена Коваль");
        card.printCardInfo();

        card.addPurchase(3000);
        card.printCardInfo();

        card.addPurchase(4000);
        card.printCardInfo();

        card.addPurchase(5000);
        card.printCardInfo();
    }
}
