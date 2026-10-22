package practice6;

public class Task22 {

    public String name;
    public double baseSalary;
    public double bonusPercentage;

    public double calculateTotalSalary() {
        return baseSalary * (1 + bonusPercentage / 100);
    }

    public double calculateTax() {
        return calculateTotalSalary() * 19.5 / 100;
    }

    public static void main(String[] args) {
        Task22 employee = new Task22();
        employee.name = "Андрій Петренко";
        employee.baseSalary = 30000;
        employee.bonusPercentage = 15;

        System.out.println("Співробітник: " + employee.name);
        System.out.println("Ставка: " + employee.baseSalary + " грн, бонус: " + employee.bonusPercentage + "%");
        System.out.println("Повна зарплата: " + employee.calculateTotalSalary() + " грн");
        System.out.println("Податок 19.5%: " + employee.calculateTax() + " грн");
    }
}
