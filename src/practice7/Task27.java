package practice7;

public class Task27 {

    public static final double PI = 3.1415926535;
    public static final double E = 2.7182818284;

    private Task27() {
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double power(double base, int exp) {
        double result = 1;
        int count = Math.abs(exp);
        for (int i = 0; i < count; i++) {
            result *= base;
        }
        if (exp < 0) {
            return 1 / result;
        }
        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int clamp(int val, int min, int max) {
        if (val < min) {
            return min;
        }
        if (val > max) {
            return max;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println("PI = " + Task27.PI);
        System.out.println("E = " + Task27.E);
        System.out.println("5! = " + Task27.factorial(5));
        System.out.println("10! = " + Task27.factorial(10));
        System.out.println("2^10 = " + Task27.power(2, 10));
        System.out.println("2^-3 = " + Task27.power(2, -3));
        System.out.println("НСД(48, 18) = " + Task27.gcd(48, 18));
        System.out.println("clamp(15, 0, 10) = " + Task27.clamp(15, 0, 10));
        System.out.println("clamp(-4, 0, 10) = " + Task27.clamp(-4, 0, 10));
        System.out.println("clamp(7, 0, 10) = " + Task27.clamp(7, 0, 10));
    }
}
