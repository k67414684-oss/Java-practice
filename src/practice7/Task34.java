package practice7;

public class Task34 {

    private String iban;
    private String owner;
    private double balance;

    public Task34(String iban, String owner, double balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }

    public boolean transferTo(Task34 recipient, double amount) {
        if (recipient == null || recipient == this) {
            return false;
        }
        if (amount <= 0 || this.balance < amount) {
            return false;
        }
        this.balance -= amount;
        recipient.balance += amount;
        return true;
    }

    public void printAccount() {
        System.out.println("IBAN: " + iban + ", власник: " + owner + ", баланс: " + balance + " грн");
    }

    public static void main(String[] args) {
        Task34 ivan = new Task34("UA001", "Іван", 10000);
        Task34 maria = new Task34("UA002", "Марія", 2000);

        boolean result = ivan.transferTo(maria, 3500);
        System.out.println("Переказ 3500 успішний: " + result);
        ivan.printAccount();
        maria.printAccount();

        result = ivan.transferTo(ivan, 100);
        System.out.println("Переказ самому собі успішний: " + result);

        result = maria.transferTo(ivan, 100000);
        System.out.println("Переказ 100000 успішний: " + result);
    }
}
