package practice7;

public class Task17 {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public String add(String a, String b) {
        return a + " " + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public String multiply(String text, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += text;
        }
        return result;
    }

    public static void main(String[] args) {
        Task17 math = new Task17();

        System.out.println(math.add(5, 7));
        System.out.println(math.add(2.5, 3.1));
        System.out.println(math.add(1, 2, 3));
        System.out.println(math.add("Hello", "World"));
        System.out.println(math.multiply(4, 6));
        System.out.println(math.multiply(1.5, 2.0));
        System.out.println(math.multiply("ab", 3));
    }
}
