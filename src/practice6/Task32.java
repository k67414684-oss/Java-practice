package practice6;

public class Task32 {

    private int pinCode = 1234;
    private boolean isLocked = true;
    private int failedAttempts = 0;

    public void enterPin(int enteredPin) {
        if (failedAttempts >= 3) {
            System.out.println("СИСТЕМА ЗАБЛОКОВАНА! Викличте охорону.");
        } else if (enteredPin == pinCode) {
            isLocked = false;
            failedAttempts = 0;
            System.out.println("PIN вірний. Замок відчинено");
        } else {
            failedAttempts++;
            System.out.println("Невірний PIN. Невдалих спроб: " + failedAttempts);
        }
    }

    public static void main(String[] args) {
        Task32 lock = new Task32();

        lock.enterPin(1111);
        lock.enterPin(2222);
        lock.enterPin(3333);
        lock.enterPin(1234);
        lock.enterPin(4444);
    }
}
