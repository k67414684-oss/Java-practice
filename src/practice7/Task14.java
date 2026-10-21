package practice7;

public class Task14 {

    private String type;
    private String size;
    private int sugarCount;
    private boolean withSyrup;
    private double finalPrice;

    public Task14(String type, String size, int sugarCount, boolean withSyrup) {
        this.type = type;
        this.size = size;
        this.sugarCount = sugarCount;
        this.withSyrup = withSyrup;
        this.finalPrice = calculatePrice();
    }

    public Task14(String type, String size) {
        this(type, size, 0, false);
    }

    public Task14(String type) {
        this(type, "Medium");
    }

    private double calculatePrice() {
        double price = 0;
        if (type.equals("Еспресо")) {
            price = 40;
        } else if (type.equals("Капучино")) {
            price = 55;
        } else if (type.equals("Лате")) {
            price = 60;
        }

        if (size.equals("Small")) {
            price = price * 1.0;
        } else if (size.equals("Medium")) {
            price = price * 1.3;
        } else if (size.equals("Large")) {
            price = price * 1.6;
        }

        if (withSyrup) {
            price += 15;
        }
        return price;
    }

    public void printReceipt() {
        System.out.println("----- Чек -----");
        System.out.println("Напій: " + type);
        System.out.println("Розмір: " + size);
        System.out.println("Цукор: " + sugarCount);
        if (withSyrup) {
            System.out.println("Сироп: так");
        } else {
            System.out.println("Сироп: ні");
        }
        System.out.println("До сплати: " + finalPrice + " грн");
        System.out.println("---------------");
    }

    public static void main(String[] args) {
        Task14 order1 = new Task14("Лате", "Large", 2, true);
        Task14 order2 = new Task14("Капучино", "Small");
        Task14 order3 = new Task14("Еспресо");

        order1.printReceipt();
        order2.printReceipt();
        order3.printReceipt();
    }
}
