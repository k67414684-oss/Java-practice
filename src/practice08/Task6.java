package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Task6 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task6: WeatherDay ---");
        double[] temps = {12.5, 14.0, 17.8, 19.2, 16.1, 13.0};
        WeatherDay day = new WeatherDay("2026-11-03", temps);
        System.out.println(day);
        temps[0] = 99.9;
        System.out.println("Після зміни зовнішнього масиву об'єкт не змінився:");
        System.out.println(day);
        System.out.printf("min = %.1f, max = %.1f, avg = %.2f%n",
                day.getMinTemp(), day.getMaxTemp(), day.getAverageTemp());
    }

    static class WeatherDay {
        private String date;
        private double[] hourlyTemps;

        public WeatherDay(String date, double[] hourlyTemps) {
            this.date = date;
            if (hourlyTemps == null) {
                this.hourlyTemps = new double[0];
            } else {
                this.hourlyTemps = new double[hourlyTemps.length];
                for (int i = 0; i < hourlyTemps.length; i++) {
                    this.hourlyTemps[i] = hourlyTemps[i];
                }
            }
        }

        public String getDate() {
            return date;
        }

        public double[] getHourlyTemps() {
            double[] copy = new double[hourlyTemps.length];
            for (int i = 0; i < hourlyTemps.length; i++) {
                copy[i] = hourlyTemps[i];
            }
            return copy;
        }

        public double getMinTemp() {
            if (hourlyTemps.length == 0) {
                return 0.0;
            }
            double min = hourlyTemps[0];
            for (int i = 1; i < hourlyTemps.length; i++) {
                if (hourlyTemps[i] < min) {
                    min = hourlyTemps[i];
                }
            }
            return min;
        }

        public double getMaxTemp() {
            if (hourlyTemps.length == 0) {
                return 0.0;
            }
            double max = hourlyTemps[0];
            for (int i = 1; i < hourlyTemps.length; i++) {
                if (hourlyTemps[i] > max) {
                    max = hourlyTemps[i];
                }
            }
            return max;
        }

        public double getAverageTemp() {
            if (hourlyTemps.length == 0) {
                return 0.0;
            }
            double sum = 0;
            for (double t : hourlyTemps) {
                sum += t;
            }
            return sum / hourlyTemps.length;
        }

        @Override
        public String toString() {
            return String.format("WeatherDay{date='%s', temps=%s, avg=%.2f}",
                    date, Arrays.toString(hourlyTemps), getAverageTemp());
        }
    }
}
