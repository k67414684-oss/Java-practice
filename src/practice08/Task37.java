package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task37 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task37: CinemaHall -> VipCinemaHall ---");
        CinemaHall hall = new CinemaHall("Зал №1", 3, 5, 150);
        hall.bookSeat(0, 0);
        hall.bookSeat(1, 2);
        hall.bookSeat(2, 4);
        hall.bookSeat(1, 2);
        System.out.println(hall);
        VipCinemaHall vip = new VipCinemaHall("VIP-зал", 3, 5, 150, 80);
        vip.bookSeat(0, 0);
        vip.bookSeat(2, 1);
        vip.bookSeat(2, 2);
        System.out.println(vip);
    }

    static class CinemaHall {
        private String hallName;
        protected boolean[][] seats;
        protected double baseTicketPrice;

        public CinemaHall(String hallName, int rows, int cols, double baseTicketPrice) {
            this.hallName = hallName;
            this.seats = new boolean[Math.max(1, rows)][Math.max(1, cols)];
            this.baseTicketPrice = Math.max(0.0, baseTicketPrice);
        }

        public String getHallName() {
            return hallName;
        }

        public boolean bookSeat(int row, int col) {
            if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
                System.out.println("  Місця [" + row + "][" + col + "] не існує");
                return false;
            }
            if (seats[row][col]) {
                System.out.println("  Місце [" + row + "][" + col + "] уже зайняте");
                return false;
            }
            seats[row][col] = true;
            return true;
        }

        public int getOccupiedCount() {
            int count = 0;
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    if (seats[i][j]) {
                        count++;
                    }
                }
            }
            return count;
        }

        public double calculateRevenue() {
            return getOccupiedCount() * baseTicketPrice;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Зал '").append(hallName).append("' (X - зайнято, O - вільно)\n");
            for (int i = 0; i < seats.length; i++) {
                sb.append("Ряд ").append(i + 1).append(": ");
                for (int j = 0; j < seats[i].length; j++) {
                    sb.append(seats[i][j] ? "[X]" : "[O]");
                }
                sb.append("\n");
            }
            sb.append(String.format("Зайнято: %d, виручка: %.2f грн", getOccupiedCount(), calculateRevenue()));
            return sb.toString();
        }
    }

    static class VipCinemaHall extends CinemaHall {
        private double complimentaryBarCost;

        public VipCinemaHall(String hallName, int rows, int cols, double baseTicketPrice, double complimentaryBarCost) {
            super(hallName, rows, cols, baseTicketPrice);
            this.complimentaryBarCost = Math.max(0.0, complimentaryBarCost);
        }

        @Override
        public double calculateRevenue() {
            double revenue = super.calculateRevenue();
            int lastRow = seats.length - 1;
            for (int j = 0; j < seats[lastRow].length; j++) {
                if (seats[lastRow][j]) {
                    revenue += baseTicketPrice * 0.5 + complimentaryBarCost;
                }
            }
            return revenue;
        }

        @Override
        public String toString() {
            return "VIP " + super.toString() + String.format("%n(в останньому ряду: +50%% до ціни та напої на %.2f грн)",
                    complimentaryBarCost);
        }
    }
}
