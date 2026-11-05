package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task19 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task19: Ticket -> StudentTicket, VipTicket ---");
        Ticket ticket = new Ticket("Концерт Антитіл", 800);
        StudentTicket studentTicket = new StudentTicket("Концерт Антитіл", 800, "KB12345678");
        VipTicket vipTicket = new VipTicket("Концерт Антитіл", 800, true, 1500);
        System.out.println(ticket);
        System.out.println(studentTicket);
        System.out.println(vipTicket);
    }

    static class Ticket {
        private String eventName;
        private double basePrice;

        public Ticket(String eventName, double basePrice) {
            this.eventName = eventName;
            this.basePrice = Math.max(0.0, basePrice);
        }

        public String getEventName() {
            return eventName;
        }

        public double getBasePrice() {
            return basePrice;
        }

        public double getFinalPrice() {
            return basePrice;
        }

        @Override
        public String toString() {
            return String.format("Ticket{event='%s', basePrice=%.2f}", eventName, basePrice);
        }
    }

    static class StudentTicket extends Ticket {
        private String studentCardNumber;

        public StudentTicket(String eventName, double basePrice, String studentCardNumber) {
            super(eventName, basePrice);
            this.studentCardNumber = studentCardNumber;
        }

        @Override
        public double getFinalPrice() {
            return super.getFinalPrice() * 0.5;
        }

        @Override
        public String toString() {
            return String.format("StudentTicket{%s, card='%s', finalPrice=%.2f}",
                    super.toString(), studentCardNumber, getFinalPrice());
        }
    }

    static class VipTicket extends Ticket {
        private boolean includesBackstage;
        private double loungeFee;

        public VipTicket(String eventName, double basePrice, boolean includesBackstage, double loungeFee) {
            super(eventName, basePrice);
            this.includesBackstage = includesBackstage;
            this.loungeFee = Math.max(0.0, loungeFee);
        }

        @Override
        public double getFinalPrice() {
            return super.getFinalPrice() + loungeFee;
        }

        @Override
        public String toString() {
            return String.format("VipTicket{%s, backstage=%s, lounge=%.2f, finalPrice=%.2f}",
                    super.toString(), includesBackstage ? "так" : "ні", loungeFee, getFinalPrice());
        }
    }
}
