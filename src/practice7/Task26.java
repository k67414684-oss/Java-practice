package practice7;

public class Task26 {

    public static final String SERVER_NAME = "AlphaEnterprise";
    public static final int MAX_CONNECTIONS = 5;

    private static int activeConnections = 0;

    public static boolean connect() {
        if (activeConnections < MAX_CONNECTIONS) {
            activeConnections++;
            return true;
        }
        return false;
    }

    public static void disconnect() {
        if (activeConnections > 0) {
            activeConnections--;
        }
    }

    public static void printServerStatus() {
        int freeSlots = MAX_CONNECTIONS - activeConnections;
        System.out.println("Сервер " + SERVER_NAME + ": підключень " + activeConnections + ", вільних слотів " + freeSlots);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            boolean connected = Task26.connect();
            if (connected) {
                System.out.println("Користувач " + i + " підключився");
            } else {
                System.out.println("Користувач " + i + ": відмова, ліміт вичерпано");
            }
        }
        Task26.printServerStatus();

        Task26.disconnect();
        Task26.printServerStatus();
    }
}
