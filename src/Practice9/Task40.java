package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task40 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task40: Git та GitHub ---");
        System.out.println("git status");
        System.out.println("git add src/main/java/semester1/practice09/");
        System.out.println("git commit -m \"feat(practice09): complete 40 tasks on encapsulation, composition and abstract classes\"");
        System.out.println("git push origin main");
    }
}
