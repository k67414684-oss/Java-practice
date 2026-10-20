package practice3;

public class Ex111 {
    public static void main(String[] args) {
            int counter1 = 0;
            int counter2 = 0;

            // 1. Укорочене "І" (Short-circuit AND)
            boolean b1 = false && (++counter1 > 0);

            // 2. Повне "І" (Bitwise / Logical AND)
            boolean b2 = false & (++counter2 > 0);

            // Виведення значень лічильників
            System.out.println("counter1: " + counter1); // Виведе 0
            System.out.println("counter2: " + counter2); // Виведе 1
    }
}
