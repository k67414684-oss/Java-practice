package practice6;

public class Task26 {

    private String username;
    private String password;

    public void setCredentials(String u, String p) {
        username = u;
        password = p;
    }

    public boolean login(String enteredUser, String enteredPass) {
        return username.equals(enteredUser) && password.equals(enteredPass);
    }

    public void changePassword(String oldPass, String newPass) {
        if (password.equals(oldPass)) {
            password = newPass;
            System.out.println("Пароль успішно змінено");
        } else {
            System.out.println("Помилка: старий пароль невірний");
        }
    }

    public static void main(String[] args) {
        Task26 account = new Task26();
        account.setCredentials("olena", "qwerty");

        System.out.println("Вхід з правильними даними: " + account.login("olena", "qwerty"));
        System.out.println("Вхід з неправильним паролем: " + account.login("olena", "12345"));

        account.changePassword("wrong", "newPass1");
        account.changePassword("qwerty", "newPass1");

        System.out.println("Вхід зі старим паролем: " + account.login("olena", "qwerty"));
        System.out.println("Вхід з новим паролем: " + account.login("olena", "newPass1"));
    }
}
