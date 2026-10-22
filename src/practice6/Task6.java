package practice6;

public class Task6 {

    public String model;
    public int batteryLevel;
    public boolean isTurnedOn;

    public static void main(String[] args) {
        Task6 phone = new Task6();
        phone.model = "Galaxy S24";
        phone.batteryLevel = 100;
        phone.isTurnedOn = true;

        System.out.println("Початковий стан: " + phone.model + ", заряд " + phone.batteryLevel + "%, увімкнений: " + phone.isTurnedOn);

        phone.batteryLevel = phone.batteryLevel - 35;
        if (phone.batteryLevel <= 0) {
            phone.batteryLevel = 0;
            phone.isTurnedOn = false;
        }

        System.out.println("Фінальний стан: " + phone.model + ", заряд " + phone.batteryLevel + "%, увімкнений: " + phone.isTurnedOn);
    }
}
