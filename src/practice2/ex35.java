public class class6 {
    public static void main(String[] args) {
        double dayTemp = 18.5;
        double nightTemp = -3.2;
        double a = Math.abs(dayTemp - nightTemp);
        double b = Math.max(dayTemp, nightTemp);
        double c = Math.min(dayTemp, nightTemp);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
