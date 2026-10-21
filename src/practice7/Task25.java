package practice7;

public class Task25 {

    private int id;
    private String username;
    private String email;

    private static int nextId = 1001;

    public Task25(String username, String email) {
        this.id = nextId++;
        this.username = username;
        this.email = email;
    }

    public static int getNextAvailableId() {
        return nextId;
    }

    public static void resetIdSequence(int startId) {
        nextId = startId;
    }

    public void printAccount() {
        System.out.println("ID: " + id + ", користувач: " + username + ", email: " + email);
    }

    public static void main(String[] args) {
        Task25 user1 = new Task25("olena", "olena@mail.com");
        Task25 user2 = new Task25("maxim", "maxim@mail.com");
        Task25 user3 = new Task25("iryna", "iryna@mail.com");

        user1.printAccount();
        user2.printAccount();
        user3.printAccount();

        System.out.println("Наступний вільний ID: " + Task25.getNextAvailableId());

        Task25.resetIdSequence(5000);
        Task25 user4 = new Task25("andriy", "andriy@mail.com");
        user4.printAccount();
    }
}
