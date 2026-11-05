package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task10 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task10: Engine + Automobile ---");
        Automobile car = new Automobile("Skoda Octavia", "Бензин", 1984);
        car.accelerate(30);
        car.startEngine();
        car.accelerate(30);
        car.accelerate(40);
        System.out.println(car);
        car.stopEngine();
        System.out.println(car);
    }

    static class Engine {
        private final String fuelType;
        private final int volumeCc;
        private int rpm;
        private boolean started;

        public Engine(String fuelType, int volumeCc) {
            this.fuelType = fuelType;
            this.volumeCc = Math.max(500, volumeCc);
        }

        public void start() {
            started = true;
            rpm = 800;
        }

        public void stop() {
            started = false;
            rpm = 0;
        }

        public void setRpm(int rpm) {
            if (!started) {
                this.rpm = 0;
                return;
            }
            this.rpm = Math.max(800, Math.min(7000, rpm));
        }

        public boolean isStarted() {
            return started;
        }

        public int getRpm() {
            return rpm;
        }

        @Override
        public String toString() {
            return "Engine{" + fuelType + ", " + volumeCc + " см3, " + (started ? "заведений" : "заглушений") + ", rpm=" + rpm + "}";
        }
    }

    static class Automobile {
        private final String model;
        private double speed;
        private final Engine engine;

        public Automobile(String model, String fuelType, int volumeCc) {
            this.model = model;
            this.engine = new Engine(fuelType, volumeCc);
        }

        public void startEngine() {
            engine.start();
        }

        public void stopEngine() {
            engine.stop();
            speed = 0;
        }

        public void accelerate(double deltaSpeed) {
            if (!engine.isStarted()) {
                System.out.println("  Двигун не заведений, " + model + " не може розганятися");
                return;
            }
            if (deltaSpeed <= 0) {
                return;
            }
            speed += deltaSpeed;
            engine.setRpm(800 + (int) (speed * 40));
        }

        @Override
        public String toString() {
            return String.format("Automobile{model='%s', speed=%.1f км/год, %s}", model, speed, engine);
        }
    }
}
