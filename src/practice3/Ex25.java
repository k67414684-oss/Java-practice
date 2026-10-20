package practice3;

public class Ex111 {
    public static void main(String[] args) {
        int x = 10;
        int divisor = 0;

        if (divisor != 0 && (x / divisor > 1)) {
            System.out.println("Успішне ділення");
        } else {
            System.out.println("Ділення безпечно пропущено завдяки short-circuit!");
        }
    }
}
