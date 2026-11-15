package practice10;

abstract class AbstractVehicle {
    private final String plateNumber;
    protected double mileageKm;
    public AbstractVehicle(String plateNumber, double mileageKm) { this.plateNumber = plateNumber; this.mileageKm = mileageKm; }
    public String getPlateNumber() { return plateNumber; }
}
interface CargoCarrier { double getMaxPayloadTons(); }
interface PassengerCarrier { int getSeatCount(); }
interface ElectricPowered { double getBatteryCapacityKwh(); }

class ElectricCityBus extends AbstractVehicle implements PassengerCarrier, ElectricPowered {
    public ElectricCityBus(String plate) { super(plate, 12000); }
    @Override public int getSeatCount() { return 45; }
    @Override public double getBatteryCapacityKwh() { return 350.0; }
}
class DieselDumpTruck extends AbstractVehicle implements CargoCarrier {
    public DieselDumpTruck(String plate) { super(plate, 85000); }
    @Override public double getMaxPayloadTons() { return 25.0; }
}
class CargoPassengerVan extends AbstractVehicle implements CargoCarrier, PassengerCarrier {
    public CargoPassengerVan(String plate) { super(plate, 42000); }
    @Override public double getMaxPayloadTons() { return 1.5; }
    @Override public int getSeatCount() { return 6; }
}

public class Ex21 {
    public static void main(String[] args) {
        AbstractVehicle[] fleet = {
                new ElectricCityBus("AA0001EE"),
                new DieselDumpTruck("BC9988AA"),
                new CargoPassengerVan("KA5544CB")
        };
        for (AbstractVehicle v : fleet) {
            System.out.print(v.getPlateNumber() + " (" + v.getClass().getSimpleName() + "): ");
            if (v instanceof PassengerCarrier pc) System.out.print("місць=" + pc.getSeatCount() + " ");
            if (v instanceof CargoCarrier cc) System.out.print("вантаж=" + cc.getMaxPayloadTons() + "т ");
            if (v instanceof ElectricPowered ep) System.out.print("батарея=" + ep.getBatteryCapacityKwh() + "кВт·год");
            System.out.println();
        }
    }
}
