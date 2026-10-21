package practice7;

public class Task11 {

    private String brand;
    private String model;
    private int year;
    private double mileage;
    private boolean engineStarted;

    public Task11(String brand, String model, int year, double mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.engineStarted = false;
    }

    public Task11(String brand, String model, int year) {
        this(brand, model, year, 0.0);
    }

    public Task11() {
        this("Unknown", "Standard", 2024);
    }

    public void startEngine() {
        engineStarted = true;
        System.out.println("Двигун " + brand + " " + model + " заведено");
    }

    public void stopEngine() {
        engineStarted = false;
        System.out.println("Двигун " + brand + " " + model + " зупинено");
    }

    public void drive(double distance) {
        if (engineStarted) {
            mileage += distance;
            System.out.println("Проїхали " + distance + " км. Пробіг: " + mileage + " км");
        } else {
            System.out.println("Спершу заведіть двигун!");
        }
    }

    public static void main(String[] args) {
        Task11 car = new Task11("Toyota", "Camry", 2024);
        car.drive(50);
        car.startEngine();
        car.drive(150);
        car.stopEngine();

        Task11 defaultCar = new Task11();
        defaultCar.startEngine();
        defaultCar.drive(20);
    }
}
