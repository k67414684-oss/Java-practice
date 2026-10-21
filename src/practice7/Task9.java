package practice7;

public class Task9 {

    private String login;
    private String email;
    private String role;
    private boolean isActive;

    public Task9(String login, String email, String role, boolean isActive) {
        this.login = login;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }

    public Task9(String login, String email) {
        this(login, email, "USER", true);
    }

    public Task9(String login) {
        this(login, login + "@domain.com");
    }

    public Task9() {
        this("guest");
    }

    public void printProfile() {
        System.out.println("Логін: " + login + ", email: " + email + ", роль: " + role + ", активний: " + isActive);
    }

    public static void main(String[] args) {
        Task9 user1 = new Task9("admin", "admin@site.com", "ADMIN", true);
        Task9 user2 = new Task9("olena", "olena@mail.com");
        Task9 user3 = new Task9("maxim");
        Task9 user4 = new Task9();

        user1.printProfile();
        user2.printProfile();
        user3.printProfile();
        user4.printProfile();
    }
}
