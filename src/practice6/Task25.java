package practice6;

public class Task25 {

    private String secretCode = "Pass123";

    public boolean verifyCode(String attempt) {
        return secretCode.equals(attempt);
    }

    public static void main(String[] args) {
        Task25 vault = new Task25();

        System.out.println("Спроба \"hacked\": " + vault.verifyCode("hacked"));
        System.out.println("Спроба \"pass123\": " + vault.verifyCode("pass123"));
        System.out.println("Спроба \"Pass123\": " + vault.verifyCode("Pass123"));
    }
}
