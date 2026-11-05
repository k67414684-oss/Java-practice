package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task11 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task11: Vehicle -> PassengerCar, CargoTruck ---");
        PassengerCar car = new PassengerCar("Skoda Octavia", 220, 50, 5);
        CargoTruck truck = new CargoTruck("MAN TGX", 120, 400, 18);
        System.out.println(car);
        System.out.println(truck);
    }

    static class Vehicle {
        protected String brand;
        protected int maxSpeed;
        protected double fuelTankCapacity;

        public Vehicle(String brand, int maxSpeed, double fuelTankCapacity) {
            this.brand = brand;
            this.maxSpeed = Math.max(0, maxSpeed);
            this.fuelTankCapacity = Math.max(0.0, fuelTankCapacity);
        }

        @Override
        public String toString() {
            return String.format("Vehicle{brand='%s', maxSpeed=%d км/год, tank=%.1f л}",
                    brand, maxSpeed, fuelTankCapacity);
        }
    }

    static class PassengerCar extends Vehicle {
        private int passengerSeats;

        public PassengerCar(String brand, int maxSpeed, double fuelTankCapacity, int passengerSeats) {
            super(brand, maxSpeed, fuelTankCapacity);
            this.passengerSeats = Math.max(1, passengerSeats);
        }

        public int getPassengerSeats() {
            return passengerSeats;
        }

        @Override
        public String toString() {
            return "PassengerCar{" + super.toString() + ", seats=" + passengerSeats + "}";
        }
    }

    static class CargoTruck extends Vehicle {
        private double maxLoadTons;

        public CargoTruck(String brand, int maxSpeed, double fuelTankCapacity, double maxLoadTons) {
            super(brand, maxSpeed, fuelTankCapacity);
            this.maxLoadTons = Math.max(0.0, maxLoadTons);
        }

        public double getMaxLoadTons() {
            return maxLoadTons;
        }

        public double getFuelConsumptionFullLoad() {
            return 20.0 + 2.5 * maxLoadTons;
        }

        public double getRangeFullLoad() {
            return fuelTankCapacity / getFuelConsumptionFullLoad() * 100.0;
        }

        @Override
        public String toString() {
            return String.format("CargoTruck{%s, maxLoad=%.1f т, витрата=%.1f л/100км, запас ходу=%.0f км}",
                    super.toString(), maxLoadTons, getFuelConsumptionFullLoad(), getRangeFullLoad());
        }
    }
}
