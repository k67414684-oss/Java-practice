package practice10;

abstract class AbstractLabDevice {
    private final String inventoryCode;
    public AbstractLabDevice(String inventoryCode) { this.inventoryCode = inventoryCode; }
    public String getInventoryCode() { return inventoryCode; }
    public abstract void performMeasurement();
}
interface Calibratable { void calibrate(double referenceValue); }
interface SelfDiagnostic { boolean runSelfCheck(); }

class ElectronicScale extends AbstractLabDevice implements Calibratable, SelfDiagnostic {
    public ElectronicScale(String code) { super(code); }
    @Override public void performMeasurement() { System.out.println("  [" + getInventoryCode() + "] Маса: 100.002 г"); }
    @Override public void calibrate(double ref) { System.out.println("  [" + getInventoryCode() + "] Відкалібровано на " + ref + " г"); }
    @Override public boolean runSelfCheck() { return true; }
}
class GlassThermometer extends AbstractLabDevice {
    public GlassThermometer(String code) { super(code); }
    @Override public void performMeasurement() { System.out.println("  [" + getInventoryCode() + "] Температура: 22.4 °C"); }
}

public class Ex23 {
    public static void main(String[] args) {
        AbstractLabDevice[] lab = { new ElectronicScale("LAB-01"), new GlassThermometer("LAB-02") };
        for (AbstractLabDevice d : lab) {
            if (d instanceof SelfDiagnostic sd && sd.runSelfCheck()) System.out.println("Самодіагностика " + d.getInventoryCode() + " пройдена!");
            if (d instanceof Calibratable cal) cal.calibrate(100.0);
            d.performMeasurement();
        }
    }
}
