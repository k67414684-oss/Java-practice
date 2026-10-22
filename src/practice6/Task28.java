package practice6;

public class Task28 {

    private double temperature;

    public void setTemperature(double t) {
        if (t < -273.15) {
            System.out.println("Помилка: температура не може бути нижчою за абсолютний нуль (-273.15)");
        } else {
            temperature = t;
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public static void main(String[] args) {
        Task28 thermometer = new Task28();

        thermometer.setTemperature(21.5);
        System.out.println("Температура: " + thermometer.getTemperature());

        thermometer.setTemperature(-300);
        System.out.println("Температура: " + thermometer.getTemperature());

        thermometer.setTemperature(-273.15);
        System.out.println("Температура: " + thermometer.getTemperature());
    }
}
