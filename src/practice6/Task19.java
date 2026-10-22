package practice6;

public class Task19 {

    public double celsiusToFahrenheit(double c) {
        return c * 1.8 + 32;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32) / 1.8;
    }

    public static void main(String[] args) {
        Task19 converter = new Task19();

        double fahrenheit = converter.celsiusToFahrenheit(25);
        System.out.println("25 °C = " + fahrenheit + " °F");

        double celsius = converter.fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + " °F = " + celsius + " °C");
    }
}
