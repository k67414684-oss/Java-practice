package practice7;

public class Task15 {

    private double width;
    private double height;
    private double depth;
    private String material;

    public Task15(double width, double height, double depth, String material) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.material = material;
    }

    public Task15(double size, String material) {
        this(size, size, size, material);
    }

    public Task15(Task15 other) {
        this(other.width, other.height, other.depth, other.material);
    }

    public double getVolume() {
        return width * height * depth;
    }

    public double getSurfaceArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    public void printBox() {
        System.out.println("Коробка " + width + " x " + height + " x " + depth + ", матеріал: " + material
                + ", об'єм: " + getVolume() + ", площа поверхні: " + getSurfaceArea());
    }

    public static void main(String[] args) {
        Task15 box1 = new Task15(10, "Картон");
        Task15 box2 = new Task15(box1);
        Task15 box3 = new Task15(5, 8, 12, "Пластик");

        box1.printBox();
        box2.printBox();
        box3.printBox();

        if (box1.getVolume() == box2.getVolume()) {
            System.out.println("Об'єми оригіналу та копії однакові");
        } else {
            System.out.println("Об'єми різні");
        }
        System.out.println("box1 == box2: " + (box1 == box2));
    }
}
