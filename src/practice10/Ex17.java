package practice10;

abstract class AbstractBird {
    protected final String species;
    protected double weightKg;
    public AbstractBird(String species, double weightKg) { this.species = species; this.weightKg = weightKg; }
    public abstract String makeSound();
}
interface FlyableUnit { double getFlightSpeedKmh(); }
interface SwimmingUnit { double getDiveDepthMeters(); }

class Falcon extends AbstractBird implements FlyableUnit {
    public Falcon() { super("Сапсан", 1.1); }
    @Override public String makeSound() { return "Кі-кі-кі!"; }
    @Override public double getFlightSpeedKmh() { return 320.0; }
}
class EmperorPenguin extends AbstractBird implements SwimmingUnit {
    public EmperorPenguin() { super("Імператорський пінгвін", 30.0); }
    @Override public String makeSound() { return "Трубний крик!"; }
    @Override public double getDiveDepthMeters() { return 500.0; }
}
class CargoPlane implements FlyableUnit {
    @Override public double getFlightSpeedKmh() { return 850.0; }
}

public class Ex17 {
    public static void main(String[] args) {
        AbstractBird[] birds = { new Falcon(), new EmperorPenguin() };
        for (AbstractBird b : birds) System.out.println(b.species + " каже: " + b.makeSound());

        FlyableUnit[] flyers = { new Falcon(), new CargoPlane() };
        for (FlyableUnit f : flyers) System.out.println(f.getClass().getSimpleName() + " швидкість: " + f.getFlightSpeedKmh() + " км/год");
    }
}
