package practice5;

public class Ex {
    public static void main(String[] args) {
        System.out.printf("%-6s | %-8s | %-6s\n", "Число", "Квадрат", "Куб");
        System.out.println("--------------------------------");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-6d | %-8d | %-6d\n", i, i * i, i * i * i);
        }
    }
}