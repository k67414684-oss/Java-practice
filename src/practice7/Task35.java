package practice7;

public class Task35 {

    public static void main(String[] args) {
        Engine engine = new Engine("ENG-777", 250);
        CarWithEngine car = new CarWithEngine("BMW", "X5", engine);

        car.printSpecs();
        car.startCar();
        car.printSpecs();
        car.turnOff();
        car.printSpecs();
    }
}

class Engine {
    private String serialNumber;
    private int horsePower;
    private boolean isRunning;

    public Engine(String serialNumber, int horsePower) {
        this.serialNumber = serialNumber;
        this.horsePower = horsePower;
        this.isRunning = false;
    }

    public void start() {
        isRunning = true;
        System.out.println("Двигун " + serialNumber + " запущено");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Двигун " + serialNumber + " зупинено");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getHorsePower() {
        return horsePower;
    }
}

class CarWithEngine {
    private String brand;
    private String model;
    private Engine engine;

    public CarWithEngine(String brand, String model, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    public void startCar() {
        this.engine.start();
        System.out.println(brand + " готовий до руху!");
    }

    public void turnOff() {
        this.engine.stop();
    }

    public void printSpecs() {
        System.out.println("Авто: " + brand + " " + model + ", потужність двигуна: " + engine.getHorsePower()
                + " к.с., двигун працює: " + engine.isRunning());
    }
}
