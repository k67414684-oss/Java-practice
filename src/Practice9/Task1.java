package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task1 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task1: ImmutableGeoPoint ---");
        ImmutableGeoPoint kyiv = new ImmutableGeoPoint(50.4501, 30.5234);
        ImmutableGeoPoint moved = kyiv.shift(0.5, -0.25);
        ImmutableGeoPoint wrong = new ImmutableGeoPoint(120, -250);
        System.out.println(kyiv);
        System.out.println(moved);
        System.out.println(wrong);
    }

    static final class ImmutableGeoPoint {
        private final double latitude;
        private final double longitude;

        public ImmutableGeoPoint(double latitude, double longitude) {
            this.latitude = Math.max(-90.0, Math.min(90.0, latitude));
            this.longitude = Math.max(-180.0, Math.min(180.0, longitude));
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public ImmutableGeoPoint shift(double dLat, double dLon) {
            return new ImmutableGeoPoint(latitude + dLat, longitude + dLon);
        }

        @Override
        public String toString() {
            return String.format("ImmutableGeoPoint{lat=%.4f, lon=%.4f}", latitude, longitude);
        }
    }
}
