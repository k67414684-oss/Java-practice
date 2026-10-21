package practice7;

public class Task36 {

    public static void main(String[] args) {
        Processor cpu = new Processor("Intel Core i7", 3.6, 12000);
        Memory ram16 = new Memory(16, 3200, 2500);
        Memory ram32 = new Memory(32, 3600, 5200);
        Computer computer = new Computer("Домашній ПК", cpu, ram16, 3000);

        computer.printSpecs();
        System.out.println("Загальна ціна: " + computer.calculateTotalPrice());

        computer.upgradeMemory(ram32);
        computer.printSpecs();
        System.out.println("Нова загальна ціна: " + computer.calculateTotalPrice());
    }
}

class Processor {
    private String model;
    private double frequencyGHz;
    private double price;

    public Processor(String model, double frequencyGHz, double price) {
        this.model = model;
        this.frequencyGHz = frequencyGHz;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getFrequencyGHz() {
        return frequencyGHz;
    }

    public double getPrice() {
        return price;
    }
}

class Memory {
    private int sizeGB;
    private int frequencyMHz;
    private double price;

    public Memory(int sizeGB, int frequencyMHz, double price) {
        this.sizeGB = sizeGB;
        this.frequencyMHz = frequencyMHz;
        this.price = price;
    }

    public int getSizeGB() {
        return sizeGB;
    }

    public int getFrequencyMHz() {
        return frequencyMHz;
    }

    public double getPrice() {
        return price;
    }
}

class Computer {
    private String title;
    private Processor cpu;
    private Memory ram;
    private double casePrice;

    public Computer(String title, Processor cpu, Memory ram, double casePrice) {
        this.title = title;
        this.cpu = cpu;
        this.ram = ram;
        this.casePrice = casePrice;
    }

    public double calculateTotalPrice() {
        return cpu.getPrice() + ram.getPrice() + casePrice;
    }

    public void upgradeMemory(Memory newRam) {
        this.ram = newRam;
        System.out.println("Апгрейд пам'яті: тепер " + newRam.getSizeGB() + " GB");
    }

    public void printSpecs() {
        System.out.println("Комп'ютер: " + title);
        System.out.println("Процесор: " + cpu.getModel() + ", " + cpu.getFrequencyGHz() + " GHz");
        System.out.println("Пам'ять: " + ram.getSizeGB() + " GB, " + ram.getFrequencyMHz() + " MHz");
        System.out.println("Ціна: " + calculateTotalPrice() + " грн");
    }
}
