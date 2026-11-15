package practice10;

abstract class IndustrialAsset {
    private final String name;
    protected final double initialCost;
    protected final int usefulLifeYears;
    public IndustrialAsset(String name, double initialCost, int usefulLifeYears) {
        this.name = name; this.initialCost = initialCost; this.usefulLifeYears = usefulLifeYears;
    }
    public String getName() { return name; }
    public abstract double getBookValueAfterYears(int years);
}
class LinearDepreciationAsset extends IndustrialAsset {
    public LinearDepreciationAsset(String name, double cost, int life) { super(name, cost, life); }
    @Override public double getBookValueAfterYears(int years) {
        return Math.max(0.0, initialCost * (1.0 - (double) years / usefulLifeYears));
    }
}
class DecliningBalanceAsset extends IndustrialAsset {
    private final double rate;
    public DecliningBalanceAsset(String name, double cost, int life, double rate) { super(name, cost, life); this.rate = rate; }
    @Override public double getBookValueAfterYears(int years) {
        return initialCost * Math.pow(1.0 - rate, years);
    }
}

public class Ex8 {
    public static void main(String[] args) {
        IndustrialAsset[] workshop = {
                new LinearDepreciationAsset("Токарний верстат", 150_000, 10),
                new DecliningBalanceAsset("Зварювальний робот", 300_000, 8, 0.20)
        };
        double total = 0;
        for (IndustrialAsset a : workshop) {
            double val = a.getBookValueAfterYears(3);
            total += val;
            System.out.printf("%s: залишкова вартість через 3 роки = %.2f грн%n", a.getName(), val);
        }
        System.out.printf("Сумарна вартість цеху: %.2f грн%n", total);
    }
}
