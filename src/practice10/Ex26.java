package practice10;

interface Rechargeable { void chargeToFull(); }
class Laptop implements Rechargeable {
    @Override public void chargeToFull() { System.out.println("  [Laptop] Акумулятор заряджено до 100%"); }
}
class ElectricScooter implements Rechargeable {
    @Override public void chargeToFull() { System.out.println("  [Scooter] Батарею заряджено до 100%"); }
}
class DesktopMonitor { }

public class Ex26 {
    public static int chargeAllPossible(Object[] items) {
        int count = 0;
        for (Object item : items) {
            if (item instanceof Rechargeable r) {
                r.chargeToFull();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Object[] warehouse = { new Laptop(), new DesktopMonitor(), new ElectricScooter(), "Просто рядок" };
        int charged = chargeAllPossible(warehouse);
        System.out.println("Успішно заряджено пристроїв: " + charged);
    }
}
