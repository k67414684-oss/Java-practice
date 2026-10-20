package practice3;

public class Ex111 {
    public static void main(String[] args) {
        int number = 5;

        if (number > 0 || (10 / 0 == 0)) {
            System.out.println("Умова виконана, аварійне ділення не викликалося!");
        }
    }
}
