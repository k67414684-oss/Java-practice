package practice6;

public class Task27 {

    private String accountNumber;
    private double balance;

    public Task27(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Помилка: сума поповнення має бути більшою за нуль");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Task27 account = new Task27("UA123456");
        account.deposit(1000);
        account.deposit(-50);
        System.out.println("Баланс: " + account.getBalance());

        boolean result = account.withdraw(5000);
        System.out.println("Зняття 5000 успішне: " + result);
        System.out.println("Баланс: " + account.getBalance());

        result = account.withdraw(400);
        System.out.println("Зняття 400 успішне: " + result);
        System.out.println("Баланс: " + account.getBalance());
    }
}
