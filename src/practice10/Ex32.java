package practice10;

class CargoContainer {
    final String id;
    public CargoContainer(String id) { this.id = id; }
}
interface HazardousCargo { int getHazardClass(); }
interface RefrigeratedCargo { double getRequiredTempC(); }

class ChemicalContainer extends CargoContainer implements HazardousCargo {
    public ChemicalContainer(String id) { super(id); }
    @Override public int getHazardClass() { return 3; }
}
class FrozenFoodContainer extends CargoContainer implements RefrigeratedCargo {
    public FrozenFoodContainer(String id) { super(id); }
    @Override public double getRequiredTempC() { return -18.0; }
}

public class Ex32 {
    public static void main(String[] args) {
        CargoContainer[] port = {
                new CargoContainer("ELEC-101"),
                new ChemicalContainer("CHEM-202"),
                new FrozenFoodContainer("FOOD-303")
        };
        for (CargoContainer c : port) {
            if (c instanceof HazardousCargo hz) System.out.println(c.id + " -> Спецбокс (Клас небезпеки: " + hz.getHazardClass() + ")");
            else if (c instanceof RefrigeratedCargo rf) System.out.println(c.id + " -> Підключити рефрижератор (" + rf.getRequiredTempC() + "°C)");
            else System.out.println(c.id + " -> Звичайний склад");
        }
    }
}
