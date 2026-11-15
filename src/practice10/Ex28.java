package practice10;

abstract class ShipModule {
    String name; boolean damaged;
    public ShipModule(String name, boolean damaged) { this.name = name; this.damaged = damaged; }
}
class ShieldGenerator extends ShipModule {
    public ShieldGenerator(String name) { super(name, false); }
    public void rechargeShields(int mj) { System.out.println("  [Shields] Поповнено щити на " + mj + " МДж"); }
}
class WarpDrive extends ShipModule {
    public WarpDrive(String name) { super(name, false); }
    public boolean checkAntimatterContainment() { return !damaged; }
}
class LifeSupportModule extends ShipModule {
    public LifeSupportModule(String name) { super(name, false); }
    public double getOxygenPercent() { return 20.9; }
}

public class Ex28 {
    public static void runShipInspection(ShipModule[] modules) {
        for (ShipModule m : modules) {
            if (m instanceof ShieldGenerator sg) sg.rechargeShields(500);
            else if (m instanceof WarpDrive wd) System.out.println("  [WarpDrive] Утримання антиматерії: " + wd.checkAntimatterContainment());
            else if (m instanceof LifeSupportModule ls) System.out.println("  [LifeSupport] Рівень кисню: " + ls.getOxygenPercent() + "%");
        }
    }

    public static void main(String[] args) {
        ShipModule[] modules = { new ShieldGenerator("Щит-А"), new WarpDrive("Двигун-X"), new LifeSupportModule("Кисень-1") };
        runShipInspection(modules);
    }
}
