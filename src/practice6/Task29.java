package practice6;

public class Task29 {

    private int speed = 0;

    public void accelerate(int delta) {
        speed = speed + delta;
        if (speed > 240) {
            speed = 240;
        }
    }

    public void brake(int delta) {
        speed = speed - delta;
        if (speed < 0) {
            speed = 0;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public static void main(String[] args) {
        Task29 car = new Task29();
        System.out.println("Швидкість: " + car.getSpeed());

        car.accelerate(100);
        System.out.println("Після розгону на 100: " + car.getSpeed());

        car.accelerate(200);
        System.out.println("Після розгону на 200: " + car.getSpeed());

        car.brake(90);
        System.out.println("Після гальмування на 90: " + car.getSpeed());

        car.brake(500);
        System.out.println("Після гальмування на 500: " + car.getSpeed());
    }
}
