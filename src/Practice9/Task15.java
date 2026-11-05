package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task15 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task15: ParcelOrder + DeliveryAddress ---");
        ParcelOrder order = new ParcelOrder("NP-0001", 2.5, new DeliveryAddress("Київ", "Хрещатик", 12));
        System.out.println(order);
        System.out.println("Зміна адреси до відправки: " + order.changeDestination(new DeliveryAddress("Львів", "Городоцька", 5)));
        order.markAsShipped();
        System.out.println("Зміна адреси після відправки: " + order.changeDestination(new DeliveryAddress("Одеса", "Дерибасівська", 3)));
        System.out.println(order);
    }

    static class DeliveryAddress {
        private final String city;
        private final String street;
        private final int postOfficeNumber;

        public DeliveryAddress(String city, String street, int postOfficeNumber) {
            this.city = city;
            this.street = street;
            this.postOfficeNumber = Math.max(1, postOfficeNumber);
        }

        public boolean isValid() {
            return city != null && !city.isBlank() && street != null && !street.isBlank();
        }

        @Override
        public String toString() {
            return "м. " + city + ", " + street + ", відділення №" + postOfficeNumber;
        }
    }

    static class ParcelOrder {
        private final String orderId;
        private double weightKg;
        private DeliveryAddress destination;
        private boolean shipped;

        public ParcelOrder(String orderId, double weightKg, DeliveryAddress destination) {
            this.orderId = orderId;
            this.weightKg = Math.max(0.1, weightKg);
            this.destination = destination;
        }

        public boolean changeDestination(DeliveryAddress newAddress) {
            if (shipped || newAddress == null || !newAddress.isValid()) {
                return false;
            }
            destination = newAddress;
            return true;
        }

        public void markAsShipped() {
            shipped = true;
        }

        @Override
        public String toString() {
            return "ParcelOrder{" + orderId + ", " + weightKg + " кг, " + destination + ", "
                    + (shipped ? "відправлено" : "очікує відправки") + "}";
        }
    }
}
