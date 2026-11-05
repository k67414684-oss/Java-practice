package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task29 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task29: final-клас ---");
        ImmutableServerCredentials credentials = new ImmutableServerCredentials("192.168.0.10", 8080, "sk-abc-123456");
        System.out.println(credentials);
    }

    static final class ImmutableServerCredentials {
        private final String host;
        private final int port;
        private final String apiKey;

        public ImmutableServerCredentials(String host, int port, String apiKey) {
            this.host = host;
            this.port = port;
            this.apiKey = apiKey;
        }

        public String getHost() {
            return host;
        }

        public int getPort() {
            return port;
        }

        public String getApiKey() {
            return apiKey;
        }

        @Override
        public String toString() {
            return "ImmutableServerCredentials{host='" + host + "', port=" + port + ", apiKey='***SECRET***'}";
        }

    }
}
