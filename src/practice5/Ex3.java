package practice5;

public class Ex {
    public static void main(String[] args) {
        int balance = 0;

        for (int month = 1; month <= 12; month++) {
            balance += 500;

            System.out.println("Місяць " + month + ": " + balance + " грн");
        }
    }
}