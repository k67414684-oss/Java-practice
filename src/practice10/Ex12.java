package practice10;

interface DataValidator {
    boolean isValid(String input);
    default String validateOrDefault(String input, String fallback) { return isValid(input) ? input : fallback; }
    static boolean isNotNullOrBlank(String s) { return s != null && !s.isBlank(); }
}
class EmailValidator implements DataValidator {
    @Override public boolean isValid(String input) {
        return DataValidator.isNotNullOrBlank(input) && input.contains("@") && input.contains(".");
    }
}
class PositiveNumberValidator implements DataValidator {
    @Override public boolean isValid(String input) {
        if (!DataValidator.isNotNullOrBlank(input)) return false;
        try { return Double.parseDouble(input) > 0; } catch (NumberFormatException e) { return false; }
    }
}

public class Ex12 {
    public static void main(String[] args) {
        DataValidator emailVal = new EmailValidator();
        DataValidator numVal = new PositiveNumberValidator();
        System.out.println("Email тест 1: " + emailVal.validateOrDefault("student@knu.ua", "none@mail.com"));
        System.out.println("Email тест 2: " + emailVal.validateOrDefault("invalid", "none@mail.com"));
        System.out.println("Число тест: " + numVal.validateOrDefault("-10", "1.0"));
    }
}
