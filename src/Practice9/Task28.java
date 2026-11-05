package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task28 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task28: AbstractSequence ---");
        AbstractSequence harmonic = new HarmonicSequence();
        AbstractSequence squares = new SquareNumbersSequence();
        System.out.println(harmonic.getTitle() + ": сума перших 5 = " + harmonic.sumFirstN(5));
        System.out.println(squares.getTitle() + ": сума перших 5 = " + squares.sumFirstN(5));
        System.out.println(squares.getTitle() + ": сума перших 10 = " + squares.sumFirstN(10));
    }

    static abstract class AbstractSequence {
        private final String title;

        public AbstractSequence(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public abstract double getTerm(int index);

        public double sumFirstN(int n) {
            double sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += getTerm(i);
            }
            return sum;
        }
    }

    static class HarmonicSequence extends AbstractSequence {

        public HarmonicSequence() {
            super("Гармонічна послідовність 1/n");
        }

        @Override
        public double getTerm(int index) {
            return 1.0 / index;
        }
    }

    static class SquareNumbersSequence extends AbstractSequence {

        public SquareNumbersSequence() {
            super("Квадрати натуральних чисел n^2");
        }

        @Override
        public double getTerm(int index) {
            return (double) index * index;
        }
    }
}
