package practice10;

interface EnergyConvertible {
    double SPEED_OF_LIGHT = 299_792_458.0;
    double JOULES_PER_KWH = 3_600_000.0;
    double getEnergyJoules();
    default double getEnergyKwh() { return getEnergyJoules() / JOULES_PER_KWH; }
}
class KineticBody implements EnergyConvertible {
    private final double massKg, velocityMs;
    public KineticBody(double massKg, double velocityMs) { this.massKg = massKg; this.velocityMs = velocityMs; }
    @Override public double getEnergyJoules() { return 0.5 * massKg * velocityMs * velocityMs; }
}
class BatteryCell implements EnergyConvertible {
    private final double wattHours;
    public BatteryCell(double wattHours) { this.wattHours = wattHours; }
    @Override public double getEnergyJoules() { return wattHours * 3600.0; }
}

public class Ex10 {
    public static void main(String[] args) {
        EnergyConvertible[] sources = { new KineticBody(1000, 30), new BatteryCell(2500) };
        for (EnergyConvertible e : sources) {
            System.out.printf("%s: %.2f Дж = %.4f кВт·год%n",
                    e.getClass().getSimpleName(), e.getEnergyJoules(), e.getEnergyKwh());
        }
    }
}
