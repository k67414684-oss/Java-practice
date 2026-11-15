package practice10;

abstract class AbstractSmartAppliance {
    private final String room, model;
    protected boolean poweredOn;
    public AbstractSmartAppliance(String room, String model, boolean poweredOn) {
        this.room = room; this.model = model; this.poweredOn = poweredOn;
    }
    public abstract double getCurrentWatts();
}
interface Dimmable { void setBrightness(int percent); }
interface HeatingCapable { void setTargetTemperature(double celsius); }

class SmartLedChandelier extends AbstractSmartAppliance implements Dimmable {
    private int brightness = 100;
    public SmartLedChandelier(String room, String model) { super(room, model, true); }
    @Override public void setBrightness(int percent) { this.brightness = Math.max(0, Math.min(100, percent)); }
    @Override public double getCurrentWatts() { return poweredOn ? 60.0 * (brightness / 100.0) : 0.0; }
}
class SmartUnderfloorHeating extends AbstractSmartAppliance implements HeatingCapable {
    private double targetTemp = 22.0;
    public SmartUnderfloorHeating(String room, String model) { super(room, model, true); }
    @Override public void setTargetTemperature(double celsius) { this.targetTemp = celsius; }
    @Override public double getCurrentWatts() { return poweredOn ? 1200.0 : 0.0; }
}

public class Ex18 {
    public static void main(String[] args) {
        SmartLedChandelier lamp = new SmartLedChandelier("Вітальня", "Philips");
        lamp.setBrightness(50);
        AbstractSmartAppliance[] home = { lamp, new SmartUnderfloorHeating("Ванна", "Devi") };
        double totalW = 0;
        for (AbstractSmartAppliance a : home) totalW += a.getCurrentWatts();
        System.out.printf("Сумарне споживання будинку: %.1f Вт%n", totalW);
    }
}
