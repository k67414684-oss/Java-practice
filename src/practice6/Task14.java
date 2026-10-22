package practice6;

public class Task14 {

    public boolean isOn;

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public void toggle() {
        isOn = !isOn;
    }

    public void status() {
        if (isOn) {
            System.out.println("Лампа світить");
        } else {
            System.out.println("Лампа вимкнена");
        }
    }

    public static void main(String[] args) {
        Task14 lamp = new Task14();
        lamp.status();

        lamp.turnOn();
        lamp.status();

        lamp.toggle();
        lamp.status();

        lamp.toggle();
        lamp.status();

        lamp.turnOff();
        lamp.status();
    }
}
