package practice7;

public class Task20 {

    public void log(String message) {
        System.out.println("[INFO] " + message);
    }

    public void log(String level, String message) {
        System.out.println("[" + level + "] " + message);
    }

    public void log(String level, int errorCode, String message) {
        System.out.println("[" + level + "] (Code: " + errorCode + "): " + message);
    }

    public void log(String tag, String message, boolean timestamp) {
        if (timestamp) {
            System.out.println("[" + tag + "] " + message + " (time: " + System.currentTimeMillis() + ")");
        } else {
            System.out.println("[" + tag + "] " + message);
        }
    }

    public static void main(String[] args) {
        Task20 logger = new Task20();

        logger.log("Програму запущено");
        logger.log("WARNING", "Закінчується вільна пам'ять");
        logger.log("ERROR", 404, "Файл не знайдено");
        logger.log("DB", "З'єднання з базою встановлено", true);
    }
}
