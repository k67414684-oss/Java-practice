package practice7;

public class Task29 {

    private String vinCode;
    private double currentMileage;

    private static int totalCars = 0;
    private static double totalCompanyMileage = 0.0;

    public Task29(String vinCode, double initialMileage) {
        this.vinCode = vinCode;
        this.currentMileage = initialMileage;
        totalCars++;
        totalCompanyMileage += initialMileage;
    }

    public void addTrip(double km) {
        this.currentMileage += km;
        totalCompanyMileage += km;
    }

    public void printCar() {
        System.out.println("Авто " + vinCode + ", пробіг: " + currentMileage + " км");
    }

    public static void printFleetSummary() {
        System.out.println("Кількість авто в парку: " + totalCars);
        System.out.println("Загальний пробіг парку: " + totalCompanyMileage + " км");
    }

    public static void main(String[] args) {
        Task29 car1 = new Task29("VIN-001", 12000);
        Task29 car2 = new Task29("VIN-002", 45000);
        Task29 car3 = new Task29("VIN-003", 0);

        car1.addTrip(150);
        car2.addTrip(320);
        car3.addTrip(80);

        car1.printCar();
        car2.printCar();
        car3.printCar();
        Task29.printFleetSummary();
    }
}
