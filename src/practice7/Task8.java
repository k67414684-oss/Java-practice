package practice7;

public class Task8 {

    private int id;
    private String fullName;
    private String position;
    private double monthlySalary;

    public Task8(int id, String fullName, String position, double monthlySalary) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.monthlySalary = monthlySalary;
    }

    public void raiseSalary(double percent) {
        monthlySalary = monthlySalary + monthlySalary * percent / 100;
    }

    public double getAnnualSalary() {
        return 12 * monthlySalary;
    }

    public void printBadge() {
        System.out.println("=====================");
        System.out.println("ID: " + id);
        System.out.println("ПІБ: " + fullName);
        System.out.println("Посада: " + position);
        System.out.println("Зарплата на місяць: " + monthlySalary + " грн");
        System.out.println("=====================");
    }

    public static void main(String[] args) {
        Task8 employee = new Task8(1, "Петренко Андрій Іванович", "Програміст", 40000.0);
        employee.printBadge();
        System.out.println("Річний дохід: " + employee.getAnnualSalary());

        employee.raiseSalary(15);
        System.out.println("Після підвищення на 15%:");
        employee.printBadge();
        System.out.println("Новий річний дохід: " + employee.getAnnualSalary());
    }
}
