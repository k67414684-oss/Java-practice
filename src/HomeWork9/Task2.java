package HomeWork9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Task2 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("================ КОНФІГУРАТОР РОБОЧОЇ СТАНЦІЇ (КОМПОЗИЦІЯ) ================");

        Motherboard board = new Motherboard("ASUS ROG B650", "AM5", 4);
        PowerSupplyUnit psu = new PowerSupplyUnit("Seasonics 750W Gold", 750, 0.90);
        WorkstationPC pc = new WorkstationPC("DeepLearning-Rig", board, psu);

        System.out.println("[ПЕРЕВІРКА СУМІСНОСТІ]:");
        pc.installComponent(new ProcessorUnit("Intel Core i9", 25000, "LGA1700", 24, 5.8, 125));
        pc.installComponent(new ProcessorUnit("AMD Ryzen 9 7950X", 21000, "AM5", 16, 5.7, 170));
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4080 Super", 52000, 16, 552, 320));
        int[] samples = {7300, 7450, 7410};
        NvmeSsdDrive ssd = new NvmeSsdDrive("Samsung 990 Pro 2TB", 5900, 2000, 7450, samples);
        pc.installComponent(ssd);

        System.out.println();
        System.out.println(pc);

        System.out.println();
        System.out.println("[ДОДАТКОВІ ПЕРЕВІРКИ]:");
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4090", 90000, 24, 512, 450));
        samples[0] = 1;
        ssd.getSpeedSamples()[1] = 2;
        System.out.println("Масив замірів після спроб зламати копії: " + Arrays.toString(ssd.getSpeedSamples()));
        pc.installComponent(new NvmeSsdDrive("WD Black SN850X 1TB", 3500, 1000, 7300, null));
        pc.installComponent(new NvmeSsdDrive("Kingston KC3000", 3200, 1000, 7000, null));
        System.out.println("===========================================================================");
    }
    static class Motherboard {
        private final String model;
        private final String socketType;
        private final int maxExpansionSlots;

        public Motherboard(String model, String socketType, int maxExpansionSlots) {
            this.model = model;
            this.socketType = socketType;
            this.maxExpansionSlots = Math.max(1, Math.min(8, maxExpansionSlots));
        }

        public String getModel() {
            return model;
        }

        public String getSocketType() {
            return socketType;
        }

        public int getMaxExpansionSlots() {
            return maxExpansionSlots;
        }

        public boolean isSocketCompatible(String cpuSocket) {
            return socketType.equalsIgnoreCase(cpuSocket);
        }
    }

    static class PowerSupplyUnit {
        private final String model;
        private final int maxOutputWatts;
        private final double efficiencyCoefficient;

        public PowerSupplyUnit(String model, int maxOutputWatts, double efficiencyCoefficient) {
            this.model = model;
            this.maxOutputWatts = Math.max(100, maxOutputWatts);
            this.efficiencyCoefficient = Math.max(0.80, Math.min(0.96, efficiencyCoefficient));
        }

        public int getSafeContinuousWatts() {
            return (int) (maxOutputWatts * 0.85);
        }

        public double calculateWallPowerDraw(int internalLoadWatts) {
            return internalLoadWatts / efficiencyCoefficient;
        }

        @Override
        public String toString() {
            return String.format("%s (Безпечний ліміт 85%%: %d Вт, ККД: %.0f%%)",
                    model, getSafeContinuousWatts(), efficiencyCoefficient * 100);
        }
    }

    static abstract class AbstractHardwareComponent {
        private final String modelName;
        private final double priceUah;

        public AbstractHardwareComponent(String modelName, double priceUah) {
            this.modelName = modelName;
            this.priceUah = Math.max(0.0, priceUah);
        }

        public String getModelName() {
            return modelName;
        }

        public double getPriceUah() {
            return priceUah;
        }

        public abstract int getPowerWatts();

        public abstract double getBenchmarkScore();

        public abstract String getCategory();

        @Override
        public String toString() {
            return String.format("[%s] %s (%d Вт | Score: %.1f)", getCategory(), modelName, getPowerWatts(), getBenchmarkScore());
        }
    }

    static class ProcessorUnit extends AbstractHardwareComponent {
        private final String socket;
        private final int cores;
        private final double boostClockGhz;
        private final int tdpWatts;

        public ProcessorUnit(String modelName, double priceUah, String socket, int cores, double boostClockGhz, int tdpWatts) {
            super(modelName, priceUah);
            this.socket = socket;
            this.cores = Math.max(1, cores);
            this.boostClockGhz = Math.max(0.1, boostClockGhz);
            this.tdpWatts = Math.max(0, tdpWatts);
        }

        public String getSocket() {
            return socket;
        }

        @Override
        public int getPowerWatts() {
            return tdpWatts;
        }

        @Override
        public double getBenchmarkScore() {
            return cores * boostClockGhz * 120.0;
        }

        @Override
        public String getCategory() {
            return "CPU";
        }
    }

    static class GraphicsAccelerator extends AbstractHardwareComponent {
        private final int vramGb;
        private final int tensorCores;
        private final int boardPowerWatts;

        public GraphicsAccelerator(String modelName, double priceUah, int vramGb, int tensorCores, int boardPowerWatts) {
            super(modelName, priceUah);
            this.vramGb = Math.max(1, vramGb);
            this.tensorCores = Math.max(0, tensorCores);
            this.boardPowerWatts = Math.max(0, boardPowerWatts);
        }

        @Override
        public int getPowerWatts() {
            return boardPowerWatts;
        }

        @Override
        public double getBenchmarkScore() {
            return vramGb * 250.0 + tensorCores * 1.5;
        }

        @Override
        public String getCategory() {
            return "GPU";
        }
    }

    static class NvmeSsdDrive extends AbstractHardwareComponent {
        private final int capacityGb;
        private final int readSpeedMbSec;
        private final int[] speedSamples;

        public NvmeSsdDrive(String modelName, double priceUah, int capacityGb, int readSpeedMbSec, int[] speedSamples) {
            super(modelName, priceUah);
            this.capacityGb = Math.max(1, capacityGb);
            this.readSpeedMbSec = Math.max(0, readSpeedMbSec);
            this.speedSamples = speedSamples == null ? new int[0] : Arrays.copyOf(speedSamples, speedSamples.length);
        }

        public int[] getSpeedSamples() {
            return Arrays.copyOf(speedSamples, speedSamples.length);
        }

        @Override
        public int getPowerWatts() {
            return 12;
        }

        @Override
        public double getBenchmarkScore() {
            return readSpeedMbSec * 0.25;
        }

        @Override
        public String getCategory() {
            return "NVMe SSD";
        }
    }

    static class WorkstationPC {
        private final String buildName;
        private final Motherboard motherboard;
        private final PowerSupplyUnit psu;
        private final AbstractHardwareComponent[] components;
        private int componentCount;

        public WorkstationPC(String buildName, Motherboard motherboard, PowerSupplyUnit psu) {
            this.buildName = buildName;
            this.motherboard = motherboard;
            this.psu = psu;
            this.components = new AbstractHardwareComponent[motherboard.getMaxExpansionSlots()];
        }

        public boolean installComponent(AbstractHardwareComponent comp) {
            if (comp == null) {
                return false;
            }
            if (componentCount >= motherboard.getMaxExpansionSlots()) {
                System.out.println("❌ Відмова: немає вільних слотів для " + comp.getModelName() + "!");
                return false;
            }
            if (comp instanceof ProcessorUnit) {
                ProcessorUnit cpu = (ProcessorUnit) comp;
                if (!motherboard.isSocketCompatible(cpu.getSocket())) {
                    System.out.printf("❌ Відмова: Процесор %s (%s) несумісний із платою %s (Сокет %s)!%n",
                            cpu.getModelName(), cpu.getSocket(), motherboard.getModel(), motherboard.getSocketType());
                    return false;
                }
            }
            if (getTotalPowerWatts() + comp.getPowerWatts() > psu.getSafeContinuousWatts()) {
                System.out.printf("❌ Відмова: %s (%d Вт) перевантажить блок живлення (ліміт %d Вт, вже %d Вт)!%n",
                        comp.getModelName(), comp.getPowerWatts(), psu.getSafeContinuousWatts(), getTotalPowerWatts());
                return false;
            }
            components[componentCount++] = comp;
            System.out.println("✅ Встановлено: " + comp);
            return true;
        }

        public int getTotalPowerWatts() {
            int total = 0;
            for (int i = 0; i < componentCount; i++) {
                total += components[i].getPowerWatts();
            }
            return total;
        }

        public double getTotalSystemScore() {
            double total = 0;
            for (int i = 0; i < componentCount; i++) {
                total += components[i].getBenchmarkScore();
            }
            return total;
        }

        public double getTotalBuildPrice() {
            double total = 0;
            for (int i = 0; i < componentCount; i++) {
                total += components[i].getPriceUah();
            }
            return total;
        }

        @Override
        public String toString() {
            int power = getTotalPowerWatts();
            boolean stable = power <= psu.getSafeContinuousWatts();
            return String.format("[ПАСПОРТ ЗБІРКИ '%s']:%n"
                            + "  Материнська плата: %s (Socket: %s, Слотів: %d/%d)%n"
                            + "  Блок живлення:     %s%n"
                            + "  Внутрішнє споживання: %d Вт (З розетки з урахуванням ККД: %.2f Вт) -> %s%n"
                            + "  Сумарний індекс продуктивності: %.2f балів%n"
                            + "  Загальна вартість конфігурації: %.2f грн",
                    buildName, motherboard.getModel(), motherboard.getSocketType(), componentCount,
                    motherboard.getMaxExpansionSlots(), psu, power, psu.calculateWallPowerDraw(power),
                    stable ? "СТАБІЛЬНО!" : "ПЕРЕВАНТАЖЕННЯ!", getTotalSystemScore(), getTotalBuildPrice());
        }
    }
}
