package practice10;

interface Measurable { double getMeasure(); }
class BankVault implements Measurable {
    private final double goldKg;
    public BankVault(double goldKg) { this.goldKg = goldKg; }
    @Override public double getMeasure() { return goldKg; }
}
class HighwayRoute implements Measurable {
    private final double lengthKm;
    public HighwayRoute(double lengthKm) { this.lengthKm = lengthKm; }
    @Override public double getMeasure() { return lengthKm; }
}
class CpuCore implements Measurable {
    private final double ghz;
    public CpuCore(double ghz) { this.ghz = ghz; }
    @Override public double getMeasure() { return ghz; }
}

public class Ex9 {
    public static double computeAverage(Measurable[] items) {
        double sum = 0;
        for (Measurable m : items) sum += m.getMeasure();
        return sum / items.length;
    }

    public static void main(String[] args) {
        Measurable[] items = { new BankVault(120.5), new HighwayRoute(450.0), new CpuCore(4.5) };
        System.out.printf("Середнє значення по масиву Measurable: %.2f%n", computeAverage(items));
    }
}
