package practice4;

public class Ex {
    public static void main(String[] args) {
        String s = "Hello";
        String encrypted = "";
        for (int i = 0; i < s.length(); i++) {
            encrypted += (char) (s.charAt(i) + 1);
        }
        System.out.println(encrypted);
    }
}
