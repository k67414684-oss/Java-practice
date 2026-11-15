package practice10;

abstract class ShippingTariff {
    public abstract String getName();
    public abstract double calculateCost(double weightKg, double distanceKm);
}
class RoadTruckTariff extends ShippingTariff {
    @Override public String getName() { return "RoadTruck"; }
    @Override public double calculateCost(double w, double d) { return 15.0 * d + 2.5 * w; }
}
class AirCargoTariff extends ShippingTariff {
    @Override public String getName() { return "AirCargo"; }
    @Override public double calculateCost(double w, double d) { return 45.0 * d + 18.0 * w + 500.0; }
}
class RailFreightTariff extends ShippingTariff {
    @Override public String getName() { return "RailFreight"; }
    @Override public double calculateCost(double w, double d) { return 1200.0 + 4.0 * d + 0.8 * w; }
}

public class Ex5 {
    public static void main(String[] args) {
        ShippingTariff[] tariffs = { new RoadTruckTariff(), new AirCargoTariff(), new RailFreightTariff() };
        ShippingTariff best = tariffs[0];
        for (ShippingTariff t : tariffs) {
            double cost = t.calculateCost(250, 600);
            System.out.printf("%s: %.2f грн%n", t.getName(), cost);
            if (cost < best.calculateCost(250, 600)) best = t;
        }
        System.out.printf("Найвигідніший тариф: %s (%.2f грн)%n", best.getName(), best.calculateCost(250, 600));
    }
}
