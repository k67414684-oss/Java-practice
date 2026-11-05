package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task11 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task11: SmartDevice (Battery + Display) ---");
        SmartDevice phone = new SmartDevice(5000, 6.7, 90);
        System.out.println(phone);
        phone.watchVideo(120);
        System.out.println(phone);
        phone.setBrightness(40);
        phone.watchVideo(120);
        System.out.println(phone);
        phone.watchVideo(1000);
        System.out.println(phone);
        phone.watchVideo(10);
    }

    static class Battery {
        private final int capacityMah;
        private int chargePercent;

        public Battery(int capacityMah, int chargePercent) {
            this.capacityMah = Math.max(1000, capacityMah);
            this.chargePercent = Math.max(0, Math.min(100, chargePercent));
        }

        public void drain(int percent) {
            chargePercent = Math.max(0, chargePercent - Math.max(0, percent));
        }

        public void charge(int percent) {
            chargePercent = Math.min(100, chargePercent + Math.max(0, percent));
        }

        public int getChargePercent() {
            return chargePercent;
        }

        @Override
        public String toString() {
            return "Battery{" + capacityMah + " мА·год, " + chargePercent + "%}";
        }
    }

    static class Display {
        private final double diagonalInches;
        private int brightnessPercent;

        public Display(double diagonalInches, int brightnessPercent) {
            this.diagonalInches = diagonalInches > 0 ? diagonalInches : 5.0;
            setBrightnessPercent(brightnessPercent);
        }

        public final void setBrightnessPercent(int brightnessPercent) {
            this.brightnessPercent = Math.max(10, Math.min(100, brightnessPercent));
        }

        public int getBrightnessPercent() {
            return brightnessPercent;
        }

        @Override
        public String toString() {
            return "Display{" + diagonalInches + "\", яскравість " + brightnessPercent + "%}";
        }
    }

    static class SmartDevice {
        private final Battery battery;
        private final Display display;
        private boolean poweredOn = true;

        public SmartDevice(int capacityMah, double diagonalInches, int brightnessPercent) {
            this.battery = new Battery(capacityMah, 100);
            this.display = new Display(diagonalInches, brightnessPercent);
        }

        public void setBrightness(int percent) {
            display.setBrightnessPercent(percent);
        }

        public void watchVideo(int minutes) {
            if (!poweredOn) {
                System.out.println("  Пристрій вимкнений, відео не запуститься");
                return;
            }
            int ratePer10Min = display.getBrightnessPercent() > 70 ? 2 : 1;
            battery.drain(minutes / 10 * ratePer10Min);
            if (battery.getChargePercent() == 0) {
                poweredOn = false;
            }
        }

        @Override
        public String toString() {
            return "SmartDevice{" + battery + ", " + display + ", " + (poweredOn ? "увімкнений" : "ВИМКНЕНИЙ") + "}";
        }
    }
}
