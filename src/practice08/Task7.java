package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task7 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task7: IntRange ---");
        IntRange range = new IntRange(10, 3);
        System.out.println(range);
        System.out.println("Чи містить 5?  " + range.contains(5));
        System.out.println("Чи містить 11? " + range.contains(11));
        range.setRange(-4, 20);
        System.out.println(range);
    }

    static class IntRange {
        private int min;
        private int max;

        public IntRange(int min, int max) {
            setRange(min, max);
        }

        public final void setRange(int min, int max) {
            if (min > max) {
                int temp = min;
                min = max;
                max = temp;
            }
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public boolean contains(int value) {
            return value >= min && value <= max;
        }

        public int getLength() {
            return max - min;
        }

        @Override
        public String toString() {
            return "[" + min + " .. " + max + "] (довжина: " + getLength() + ")";
        }
    }
}
