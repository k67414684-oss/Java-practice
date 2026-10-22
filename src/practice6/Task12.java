package practice6;

public class Task12 {

    public String currentColor;

    public void changeColor(String newColor) {
        currentColor = newColor;
    }

    public void showSignal() {
        if (currentColor.equals("Червоний")) {
            System.out.println("Червоний - Стій!");
        } else if (currentColor.equals("Жовтий")) {
            System.out.println("Жовтий - Увага!");
        } else if (currentColor.equals("Зелений")) {
            System.out.println("Зелений - Їдь!");
        }
    }

    public static void main(String[] args) {
        Task12 light = new Task12();

        light.changeColor("Червоний");
        light.showSignal();

        light.changeColor("Жовтий");
        light.showSignal();

        light.changeColor("Зелений");
        light.showSignal();
    }
}
