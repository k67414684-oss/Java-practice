package practice7;

public class Task3 {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public Task3(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance < 0) {
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void printAccount() {
        System.out.println("Рахунок: " + accountNumber + ", власник: " + ownerName + ", баланс: " + balance + " грн");
    }

    public static void main(String[] args) {
        Task3 account = new Task3("UA123456", "Олена Коваль", 1000.0);
        account.printAccount();

        account.deposit(500.0);
        System.out.println("Після поповнення на 500:");
        account.printAccount();

        boolean result = account.withdraw(5000.0);
        System.out.println("Зняття 5000 успішне: " + result);

        result = account.withdraw(300.0);
        System.out.println("Зняття 300 успішне: " + result);
        account.printAccount();
    }
}
