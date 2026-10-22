package practice6;

public class Task20 {

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public boolean isPositive(int n) {
        return n > 0;
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Task20 checker = new Task20();
        int[] numbers = {7, 12, -5};

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            System.out.println("Число " + n + ": парне - " + checker.isEven(n) + ", додатне - " + checker.isPositive(n)
                    + ", просте - " + checker.isPrime(n));
        }
    }
}
