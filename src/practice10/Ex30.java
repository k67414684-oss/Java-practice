package practice10;

abstract class AbstractCustomer {
    public abstract double getDiscountPercent();
    public final double calculateFinalPrice(double price) {
        return price * (1.0 - getDiscountPercent() / 100.0);
    }
}
class VipCustomer extends AbstractCustomer { @Override public double getDiscountPercent() { return 20.0; } }
class StudentCustomer extends AbstractCustomer { @Override public double getDiscountPercent() { return 10.0; } }
class RegularCustomer extends AbstractCustomer { @Override public double getDiscountPercent() { return 0.0; } }

public class Ex30 {
    public static void main(String[] args) {
        AbstractCustomer[] customers = { new VipCustomer(), new StudentCustomer(), new RegularCustomer() };
        for (AbstractCustomer c : customers) {
            System.out.printf("%s -> ціна зі знижкою: %.2f грн%n",
                    c.getClass().getSimpleName(), c.calculateFinalPrice(1000.0));
        }
    }
}
