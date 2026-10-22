package practice6;

public class Task23 {

    public String formatTitle(String text) {
        return "*** " + text.toUpperCase() + " ***";
    }

    public int countVowels(String text) {
        String vowels = "аоуеиіяюєїaeiou";
        String lower = text.toLowerCase();
        int count = 0;
        for (int i = 0; i < lower.length(); i++) {
            if (vowels.indexOf(lower.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Task23 formatter = new Task23();

        System.out.println(formatter.formatTitle("Привіт, світе"));
        System.out.println("Голосних у слові \"Програмування\": " + formatter.countVowels("Програмування"));
        System.out.println("Голосних у слові \"Education\": " + formatter.countVowels("Education"));
    }
}
