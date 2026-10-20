public class class6 {
    public static void main(String[] args) {
        double a = 1.0;
        double b = -7.0;
        double c = 10.0;
        double result = Math.pow(b, 2) - 4 * a * c;
        double xOne = -b + Math.sqrt(result) / 2 * a;
        double xTwo = -b - Math.sqrt(result) / 2 * a;

        System.out.println(result);
        System.out.println(xOne);
        System.out.println(xTwo);

    }
}
