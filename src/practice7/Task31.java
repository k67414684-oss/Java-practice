package practice7;

public class Task31 {

    private String sessionToken;
    private String hostPlayer;
    private boolean isActive;

    private static int activeSessionsCount = 0;
    private static int tokenCounter = 1;
    public static final int MAX_SESSIONS = 3;

    private Task31(String host) {
        this.hostPlayer = host;
        this.sessionToken = "SESSION-" + tokenCounter;
        tokenCounter++;
        this.isActive = true;
    }

    public static Task31 createSession(String host) {
        if (activeSessionsCount >= MAX_SESSIONS) {
            System.out.println("Помилка: усі сервера перевантажені!");
            return null;
        }
        activeSessionsCount++;
        return new Task31(host);
    }

    public void terminate() {
        if (isActive) {
            isActive = false;
            activeSessionsCount--;
            System.out.println("Сесію " + sessionToken + " завершено");
        }
    }

    public void printSession() {
        System.out.println("Сесія " + sessionToken + ", хост: " + hostPlayer + ", активна: " + isActive);
    }

    public static void main(String[] args) {
        Task31 s1 = Task31.createSession("Player1");
        Task31 s2 = Task31.createSession("Player2");
        Task31 s3 = Task31.createSession("Player3");
        Task31 s4 = Task31.createSession("Player4");

        System.out.println("Четверта сесія null: " + (s4 == null));

        s1.printSession();
        s2.printSession();
        s3.printSession();

        s1.terminate();
        Task31 s5 = Task31.createSession("Player5");
        if (s5 != null) {
            s5.printSession();
        }
    }
}
