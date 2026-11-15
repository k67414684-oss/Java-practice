package practice10;

interface PowerProducer { double produceMw(); }
interface WeatherDependent { void updateWeatherCondition(double factor); }

abstract class AbstractPowerStation implements PowerProducer {
    private final String stationId;
    public AbstractPowerStation(String stationId) { this.stationId = stationId; }
    public String getStationId() { return stationId; }
    public final double getNetOutputMw() { return produceMw() * 0.95; }
}
class NuclearStation extends AbstractPowerStation {
    public NuclearStation(String id) { super(id); }
    @Override public double produceMw() { return 1000.0; }
}
class SolarFarmStation extends AbstractPowerStation implements WeatherDependent {
    private double sunFactor = 1.0;
    public SolarFarmStation(String id) { super(id); }
    @Override public void updateWeatherCondition(double factor) { this.sunFactor = factor; }
    @Override public double produceMw() { return 150.0 * sunFactor; }
}
class HydroDamStation extends AbstractPowerStation implements WeatherDependent {
    private double waterFactor = 1.0;
    public HydroDamStation(String id) { super(id); }
    @Override public void updateWeatherCondition(double factor) { this.waterFactor = factor; }
    @Override public double produceMw() { return 300.0 * waterFactor; }
}

public class Ex37 {
    public static void main(String[] args) {
        PowerProducer[] grid = { new NuclearStation("АЕС-1"), new SolarFarmStation("СЕС-1"), new HydroDamStation("ГЕС-1") };
        double netTotal = 0;
        for (PowerProducer pp : grid) {
            if (pp instanceof WeatherDependent wd) wd.updateWeatherCondition(0.75);
            if (pp instanceof AbstractPowerStation aps) {
                System.out.printf("%s: чиста генерація = %.2f МВт%n", aps.getStationId(), aps.getNetOutputMw());
                netTotal += aps.getNetOutputMw();
            }
        }
        System.out.printf("Сумарна потужність мережі: %.2f МВт%n", netTotal);
    }
}
