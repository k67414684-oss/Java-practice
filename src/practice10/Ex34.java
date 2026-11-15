package practice10;

abstract class AbstractSecurityProtocol {
    protected abstract boolean authenticateUser(String token);
    protected abstract String executePayload(String command);

    public final String runSecureCommand(String token, String command) {
        if (token == null || !authenticateUser(token)) return "403 FORBIDDEN";
        return "[AUDITED] " + executePayload(command);
    }
}
class JwtSecurityProtocol extends AbstractSecurityProtocol {
    @Override protected boolean authenticateUser(String token) { return token.startsWith("eyJ"); }
    @Override protected String executePayload(String command) { return "JWT_RUN(" + command + ")"; }
}
class ApiKeySecurityProtocol extends AbstractSecurityProtocol {
    @Override protected boolean authenticateUser(String token) { return token.length() >= 16; }
    @Override protected String executePayload(String command) { return "API_RUN(" + command + ")"; }
}

public class Ex34 {
    public static void main(String[] args) {
        AbstractSecurityProtocol[] protocols = { new JwtSecurityProtocol(), new ApiKeySecurityProtocol() };
        System.out.println(protocols[0].runSecureCommand("eyJhbGciOiJIUzI1NiJ9", "GET_USERS"));
        System.out.println(protocols[1].runSecureCommand("short_key", "DELETE_ALL"));
    }
}
