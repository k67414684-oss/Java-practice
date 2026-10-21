package practice7;

public class Task23 {

    public double calculate(double baseRate) {
        return baseRate;
    }

    public double calculate(double baseRate, double fixedBonus) {
        return baseRate + fixedBonus;
    }

    public double calculate(double baseRate, double bonusPercent, boolean isTaxDeducted) {
        double total = baseRate + baseRate * bonusPercent / 100;
        if (isTaxDeducted) {
            total = total - total * 19.5 / 100;
        }
        return total;
    }

    public double calculate(double baseRate, int overtimeHours, double overtimeHourlyRate) {
        return baseRate + overtimeHours * overtimeHourlyRate;
    }

    public static void main(String[] args) {
        Task23 calculator = new Task23();

        System.out.println("Лише ставка: " + calculator.calculate(20000.0));
        System.out.println("Ставка + премія 3000: " + calculator.calculate(20000.0, 3000.0));
        System.out.println("Ставка + 10% бонус з податком: " + calculator.calculate(20000.0, 10.0, true));
        System.out.println("Ставка + 10% бонус без податку: " + calculator.calculate(20000.0, 10.0, false));
        System.out.println("Ставка + 12 годин понаднормово по 250: " + calculator.calculate(20000.0, 12, 250.0));
    }
}
