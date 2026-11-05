package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task5 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task5: RgbColor ---");
        RgbColor orange = new RgbColor(255, 165, 0);
        RgbColor blue = new RgbColor(0, 0, 300);
        System.out.println(orange);
        System.out.println(blue);
        System.out.println("Інверсія помаранчевого: " + orange.invert());
        System.out.println("Мікс помаранчевого та синього: " + orange.mixWith(blue));
    }

    static final class RgbColor {
        private final int red;
        private final int green;
        private final int blue;

        public RgbColor(int red, int green, int blue) {
            this.red = clamp(red);
            this.green = clamp(green);
            this.blue = clamp(blue);
        }

        private static int clamp(int val) {
            return Math.max(0, Math.min(255, val));
        }

        public String toHex() {
            return String.format("#%02X%02X%02X", red, green, blue);
        }

        public RgbColor invert() {
            return new RgbColor(255 - red, 255 - green, 255 - blue);
        }

        public RgbColor mixWith(RgbColor other) {
            return new RgbColor((red + other.red) / 2, (green + other.green) / 2, (blue + other.blue) / 2);
        }

        @Override
        public String toString() {
            return "RgbColor{" + red + ", " + green + ", " + blue + " | " + toHex() + "}";
        }
    }
}
