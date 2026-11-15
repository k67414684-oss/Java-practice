package practice10;

interface Flyable { void takeOff(); double getMaxAltitude(); }
interface Swimmable { void dive(double depthMeters); double getMaxDepth(); }
interface GpsTrackable { String getCoordinates(); }

class AmphibiousRescueDrone implements Flyable, Swimmable, GpsTrackable {
    @Override public void takeOff() { System.out.println("Дрон злетів у повітря!"); }
    @Override public double getMaxAltitude() { return 2000.0; }
    @Override public void dive(double depthMeters) { System.out.println("Дрон занурився на глибину " + depthMeters + " м!"); }
    @Override public double getMaxDepth() { return 50.0; }
    @Override public String getCoordinates() { return "50.4501° N, 30.5234° E"; }
}

public class Ex11 {
    public static void testFlight(Flyable f) { f.takeOff(); System.out.println("Макс. висота: " + f.getMaxAltitude() + " м"); }
    public static void testDiving(Swimmable s) { s.dive(15.0); System.out.println("Макс. глибина: " + s.getMaxDepth() + " м"); }
    public static void logPosition(GpsTrackable g) { System.out.println("GPS координати: " + g.getCoordinates()); }

    public static void main(String[] args) {
        AmphibiousRescueDrone drone = new AmphibiousRescueDrone();
        testFlight(drone);
        testDiving(drone);
        logPosition(drone);
    }
}
