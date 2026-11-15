package practice10;

abstract class NotificationSender {
    private final String recipient;
    public NotificationSender(String recipient) { this.recipient = recipient; }
    public String getRecipient() { return recipient; }
    public abstract String send(String message);
}

class EmailSender extends NotificationSender {
    public EmailSender(String recipient) { super(recipient); }
    @Override public String send(String msg) { return "[EMAIL -> " + getRecipient() + "] Subject: ALERT | " + msg; }
}

class SmsSender extends NotificationSender {
    public SmsSender(String recipient) { super(recipient); }
    @Override public String send(String msg) {
        String trimmed = msg.length() > 70 ? msg.substring(0, 67) + "..." : msg;
        return "[SMS -> " + getRecipient() + "] " + trimmed;
    }
}

class TelegramBotSender extends NotificationSender {
    public TelegramBotSender(String recipient) { super(recipient); }
    @Override public String send(String msg) { return "[TG -> " + getRecipient() + "] 🚨 **ALERT:** `" + msg + "`"; }
}

public class Ex4 {
    public static void broadcastAlert(NotificationSender[] senders, String alertText) {
        for (NotificationSender s : senders) System.out.println(s.send(alertText));
    }

    public static void main(String[] args) {
        NotificationSender[] senders = {
                new EmailSender("admin@corp.ua"),
                new SmsSender("+380501234567"),
                new TelegramBotSender("@devops_alert")
        };
        broadcastAlert(senders, "Критичне навантаження на сервер баз даних понад 95%!");
    }
}
