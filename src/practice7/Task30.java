package practice7;

public class Task30 {

    private Task30() {
    }

    public static boolean isPalindrome(String s) {
        String clean = s.replace(" ", "").toLowerCase();
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static int countVowels(String s) {
        String vowels = "aeiouyаеєиіїоуюя";
        String lower = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < lower.length(); i++) {
            if (vowels.indexOf(lower.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static String maskCardNumber(String cardNumber) {
        int totalDigits = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            if (Character.isDigit(cardNumber.charAt(i))) {
                totalDigits++;
            }
        }
        String result = "";
        int digitIndex = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            char c = cardNumber.charAt(i);
            if (Character.isDigit(c)) {
                if (digitIndex >= totalDigits - 4) {
                    result += c;
                } else {
                    result += '*';
                }
                digitIndex++;
            } else {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Task30.isPalindrome("А роза упала на лапу Азора"));
        System.out.println(Task30.isPalindrome("Hello"));
        System.out.println(Task30.reverse("Привіт"));
        System.out.println(Task30.countVowels("Programming in Java"));
        System.out.println(Task30.countVowels("Україна"));
        System.out.println(Task30.maskCardNumber("1234 5678 9012 3456"));
    }
}
