package practice6;

public class Task5 {

    public String name;
    public double price;
    public int quantity;

    public static void main(String[] args) {
        Task5 product = new Task5();
        product.name = "Монітор";
        product.price = 6500.0;
        product.quantity = 8;

        double totalCost = product.price * product.quantity;

        System.out.println("Товар: " + product.name);
        System.out.println("Ціна за одиницю: " + product.price + " грн");
        System.out.println("Кількість: " + product.quantity);
        System.out.println("Загальна вартість партії: " + totalCost + " грн");
    }
}
