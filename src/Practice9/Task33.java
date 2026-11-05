package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task33 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task33: DesktopPC ---");
        DesktopPC pc = new DesktopPC(650, 5);
        pc.addPart(new ProcessorPart("Ryzen 7 7800X3D", 15000, 8, 120));
        pc.addPart(new VideoCardPart("RTX 4070", 25000, 12, 200));
        System.out.println(pc);
        pc.addPart(new VideoCardPart("RTX 4090", 80000, 24, 450));
        System.out.println(pc);
    }

    static abstract class AbstractPcPart {
        private final String model;
        private final double priceUah;

        public AbstractPcPart(String model, double priceUah) {
            this.model = model;
            this.priceUah = Math.max(0.0, priceUah);
        }

        public double getPriceUah() {
            return priceUah;
        }

        public abstract int getPowerConsumptionWatts();

        @Override
        public String toString() {
            return String.format("%s{%s, %.0f грн, %d Вт}", getClass().getSimpleName(), model, priceUah, getPowerConsumptionWatts());
        }
    }

    static class ProcessorPart extends AbstractPcPart {
        private final int cores;
        private final int watts;

        public ProcessorPart(String model, double priceUah, int cores, int watts) {
            super(model, priceUah);
            this.cores = Math.max(1, cores);
            this.watts = Math.max(0, watts);
        }

        @Override
        public int getPowerConsumptionWatts() {
            return watts;
        }
    }

    static class VideoCardPart extends AbstractPcPart {
        private final int vramGb;
        private final int watts;

        public VideoCardPart(String model, double priceUah, int vramGb, int watts) {
            super(model, priceUah);
            this.vramGb = Math.max(1, vramGb);
            this.watts = Math.max(0, watts);
        }

        @Override
        public int getPowerConsumptionWatts() {
            return watts;
        }
    }

    static class DesktopPC {
        private final int psuMaxWatts;
        private final AbstractPcPart[] parts;
        private int partCount;

        public DesktopPC(int psuMaxWatts, int capacity) {
            this.psuMaxWatts = Math.max(100, psuMaxWatts);
            this.parts = new AbstractPcPart[Math.max(1, capacity)];
        }

        public boolean addPart(AbstractPcPart part) {
            if (part == null || partCount >= parts.length) {
                return false;
            }
            parts[partCount++] = part;
            return true;
        }

        public int getTotalPowerWatts() {
            int total = 0;
            for (int i = 0; i < partCount; i++) {
                total += parts[i].getPowerConsumptionWatts();
            }
            return total;
        }

        public boolean isStable() {
            return getTotalPowerWatts() * 1.2 <= psuMaxWatts;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("DesktopPC{БЖ " + psuMaxWatts + " Вт");
            for (int i = 0; i < partCount; i++) {
                sb.append("\n  ").append(parts[i]);
            }
            sb.append(String.format("%n  Споживання: %d Вт (з запасом 20%%: %.0f Вт) -> %s}",
                    getTotalPowerWatts(), getTotalPowerWatts() * 1.2, isStable() ? "СТАБІЛЬНО" : "БЖ НЕ ВИТЯГНЕ"));
            return sb.toString();
        }
    }
}
