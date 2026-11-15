package practice10;

interface TextProcessor { String process(String text); }
interface ReversibleProcessor extends TextProcessor { String reverseProcess(String text); }

class CaesarCipherProcessor implements ReversibleProcessor {
    private final int shift;
    public CaesarCipherProcessor(int shift) { this.shift = shift; }
    @Override public String process(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append((char) (c + shift));
        return sb.toString();
    }
    @Override public String reverseProcess(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) sb.append((char) (c - shift));
        return sb.toString();
    }
}
class WhitespaceTrimmerProcessor implements TextProcessor {
    @Override public String process(String text) { return text.trim().replaceAll("\\s+", " "); }
}

public class Ex24 {
    public static void main(String[] args) {
        String raw = "   Hello    Java   21   ";
        TextProcessor[] pipeline = { new WhitespaceTrimmerProcessor(), new CaesarCipherProcessor(2) };
        String current = raw;
        for (TextProcessor tp : pipeline) current = tp.process(current);
        System.out.println("Після конвеєра: '" + current + "'");

        if (pipeline[1] instanceof ReversibleProcessor rp) {
            System.out.println("Дешифровано: '" + rp.reverseProcess(current) + "'");
        }
    }
}
