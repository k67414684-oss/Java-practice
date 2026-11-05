package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task26 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task26: BaseVehicle -> MotorCar -> ElectricCar ---");
        ElectricCar tesla = new ElectricCar("Tesla Model 3", 2024, 283, 4, 60.0, 513);
        System.out.println(tesla);
    }

    static class BaseVehicle {
        private String brand;
        private int year;

        public BaseVehicle(String brand, int year) {
            this.brand = brand;
            this.year = year;
        }

        public String getBrand() {
            return brand;
        }

        public int getYear() {
            return year;
        }

        @Override
        public String toString() {
            return "BaseVehicle{brand='" + brand + "', year=" + year + "}";
        }
    }

    static class MotorCar extends BaseVehicle {
        private int horsePower;
        private int doorsCount;

        public MotorCar(String brand, int year, int horsePower, int doorsCount) {
            super(brand, year);
            this.horsePower = Math.max(0, horsePower);
            this.doorsCount = Math.max(1, doorsCount);
        }

        public int getHorsePower() {
            return horsePower;
        }

        public int getDoorsCount() {
            return doorsCount;
        }

        @Override
        public String toString() {
            return "MotorCar{" + super.toString() + ", hp=" + horsePower + ", doors=" + doorsCount + "}";
        }
    }

    static class ElectricCar extends MotorCar {
        private double batteryCapacityKWh;
        private int rangeKm;

        public ElectricCar(String brand, int year, int horsePower, int doorsCount,
                           double batteryCapacityKWh, int rangeKm) {
            super(brand, year, horsePower, doorsCount);
            this.batteryCapacityKWh = Math.max(0.0, batteryCapacityKWh);
            this.rangeKm = Math.max(0, rangeKm);
        }

        public double getBatteryCapacityKWh() {
            return batteryCapacityKWh;
        }

        public int getRangeKm() {
            return rangeKm;
        }

        @Override
        public String toString() {
            return String.format("ElectricCar{%s, battery=%.1f кВт·год, range=%d км}",
                    super.toString(), batteryCapacityKWh, rangeKm);
        }
    }
}
