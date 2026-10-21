package practice7;

public class Task32 {

    public static final double G = 9.80665;
    public static final double SPEED_OF_LIGHT = 299792458.0;

    private Task32() {
    }

    public static double freeFallDistance(double seconds) {
        return G * seconds * seconds / 2;
    }

    public static double kineticEnergy(double massKg, double velocityMs) {
        return massKg * velocityMs * velocityMs / 2;
    }

    public static double restEnergy(double massKg) {
        return massKg * SPEED_OF_LIGHT * SPEED_OF_LIGHT;
    }

    public static void main(String[] args) {
        System.out.println("Енергія спокою 1 грама: " + Task32.restEnergy(0.001) + " Дж");
        System.out.println("Відстань падіння за 5 секунд: " + Task32.freeFallDistance(5) + " м");
        System.out.println("Кінетична енергія 1200 кг при 20 м/с: " + Task32.kineticEnergy(1200, 20) + " Дж");
    }
}
