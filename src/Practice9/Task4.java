package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task4 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task4: ClosedInterval ---");
        ClosedInterval a = new ClosedInterval(10, 2);
        ClosedInterval b = new ClosedInterval(8, 15);
        ClosedInterval c = new ClosedInterval(20, 30);
        System.out.println(a);
        System.out.println(b);
        System.out.println("a перетинається з b: " + a.overlaps(b));
        System.out.println("a перетинається з c: " + a.overlaps(c));
        c.resize(50, 40);
        System.out.println(c);
    }

    static class ClosedInterval {
        private double start;
        private double end;

        public ClosedInterval(double start, double end) {
            resize(start, end);
        }

        public final void resize(double newStart, double newEnd) {
            if (newStart > newEnd) {
                double temp = newStart;
                newStart = newEnd;
                newEnd = temp;
            }
            this.start = newStart;
            this.end = newEnd;
        }

        public double getStart() {
            return start;
        }

        public double getEnd() {
            return end;
        }

        public double getLength() {
            return end - start;
        }

        public double getMidpoint() {
            return (start + end) / 2.0;
        }

        public boolean overlaps(ClosedInterval other) {
            return start <= other.end && other.start <= end;
        }

        @Override
        public String toString() {
            return String.format("[%.2f; %.2f] (центр: %.2f, довжина: %.2f)", start, end, getMidpoint(), getLength());
        }
    }
}
