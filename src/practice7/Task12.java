package practice7;

public class Task12 {

    private int brightness;
    private int colorTemp;
    private boolean isOn;

    public Task12(int brightness, int colorTemp, boolean isOn) {
        if (brightness < 0) {
            this.brightness = 0;
        } else if (brightness > 100) {
            this.brightness = 100;
        } else {
            this.brightness = brightness;
        }
        if (colorTemp < 2700) {
            this.colorTemp = 2700;
        } else if (colorTemp > 6500) {
            this.colorTemp = 6500;
        } else {
            this.colorTemp = colorTemp;
        }
        this.isOn = isOn;
    }

    public Task12(int brightness) {
        this(brightness, 4000, true);
    }

    public Task12() {
        this(50);
    }

    public void printStatus() {
        System.out.println("Лампочка: яскравість " + brightness + "%, температура " + colorTemp + " K, увімкнена: " + isOn);
    }

    public static void main(String[] args) {
        Task12 bulb1 = new Task12(80, 5000, false);
        Task12 bulb2 = new Task12(30);
        Task12 bulb3 = new Task12();
        Task12 bulb4 = new Task12(150, 9000, true);

        bulb1.printStatus();
        bulb2.printStatus();
        bulb3.printStatus();
        bulb4.printStatus();
    }
}
