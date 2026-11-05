package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task28 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task28: final-метод ---");
        CustomTerminal terminal = new CustomTerminal();
        System.out.println(terminal.getWelcomeBanner());
        System.out.println(terminal.login("vlad"));
    }

    static class SecurityTerminal {

        public final String generateAuthHash(String user) {
            return "AUTH-SHA-" + user.toUpperCase();
        }

        public String getWelcomeBanner() {
            return "Ласкаво просимо до захищеного терміналу";
        }
    }

    static class CustomTerminal extends SecurityTerminal {

        @Override
        public String getWelcomeBanner() {
            return "*** CUSTOM TERMINAL *** " + super.getWelcomeBanner();
        }

        public String login(String user) {
            return "Вхід користувача " + user + ", токен: " + generateAuthHash(user);
        }
    }
}
