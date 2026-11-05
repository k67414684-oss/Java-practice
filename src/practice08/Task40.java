package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task40 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task40: Git та GitHub ---");
        System.out.println("git status");
        System.out.println("git add src/main/java/semester1/practice08/");
        System.out.println("git commit -m \"Complete Practice 08 tasks on encapsulation, inheritance and toString\"");
        System.out.println("git push origin main");
    }
}
