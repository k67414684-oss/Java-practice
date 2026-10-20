public class ss1 { public static void main(String[] args) {
    int score = 100;
    int a = score += 50;
    int b = score -= 20;
    int c = score *= 2;
    int d = score /= 4;

    System.out.println("Очікуваний результат:");
    System.out.println("Після додавання: " + a);
    System.out.println("Після віднімання: " + b);
    System.out.println("Після множення: " + c);
    System.out.println("Після ділення: " + d);
    }
}
