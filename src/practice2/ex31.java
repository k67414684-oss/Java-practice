public class ss1 {
    public static void main(String[] args) {
        boolean hasPassword = true;
        boolean hasSmsCode = true;
        boolean isAccountBlocked = false;
        boolean canLogin = hasPassword && hasSmsCode && !isAccountBlocked;

        System.out.println(canLogin);
    }
}
