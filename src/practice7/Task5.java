package practice7;

public class Task5 {

    private String name;
    private double price;
    private int quantity;
    private String category;

    public Task5(String name, double price, int quantity, String category) {
        this.name = name;
        this.category = category;
        if (price < 0) {
            this.price = 0.0;
        } else {
            this.price = price;
        }
        if (quantity < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public void applyDiscount(double percent) {
        if (percent >= 0 && percent <= 100) {
            price = price - price * percent / 100;
        }
    }

    public void printProduct() {
        System.out.println("----------------------");
        System.out.println("Товар: " + name);
        System.out.println("Категорія: " + category);
        System.out.println("Ціна: " + price + " грн");
        System.out.println("Кількість: " + quantity);
        System.out.println("Вартість партії: " + getTotalValue() + " грн");
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        Task5 product = new Task5("Монітор", 5000.0, 10, "Електроніка");
        product.printProduct();

        product.applyDiscount(20);
        System.out.println("Після знижки 20%:");
        product.printProduct();
        System.out.println("Нова сума партії: " + product.getTotalValue());

        Task5 wrong = new Task5("Брак", -100, -3, "Різне");
        wrong.printProduct();
    }
}
