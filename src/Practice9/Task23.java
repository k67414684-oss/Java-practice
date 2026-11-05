package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task23 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task23: PassengerTrain ---");
        PassengerTrain train = new PassengerTrain("Київ - Львів", 4);
        train.attachCarriage(new TrainCarriage(1, "Купе", 36, 10));
        train.attachCarriage(new TrainCarriage(2, "Плацкарт", 54, 54));
        train.attachCarriage(new TrainCarriage(3, "Інтерсіті", 60, 20));
        System.out.println(train);
        System.out.println("Вільних місць: " + train.getTotalFreeSeats());
        System.out.println("Купити 5 квитків у вагон 3: " + train.bookTicketsInCarriage(3, 5));
        System.out.println("Купити 1 квиток у вагон 2:  " + train.bookTicketsInCarriage(2, 1));
        System.out.println("Купити 1 квиток у вагон 9:  " + train.bookTicketsInCarriage(9, 1));
        System.out.println("Вільних місць: " + train.getTotalFreeSeats());
    }

    static class TrainCarriage {
        private final int carriageNumber;
        private final String type;
        private final int totalSeats;
        private int occupiedSeats;

        public TrainCarriage(int carriageNumber, String type, int totalSeats, int occupiedSeats) {
            this.carriageNumber = carriageNumber;
            this.type = type;
            this.totalSeats = Math.max(1, totalSeats);
            this.occupiedSeats = Math.max(0, Math.min(this.totalSeats, occupiedSeats));
        }

        public int getCarriageNumber() {
            return carriageNumber;
        }

        public int getFreeSeats() {
            return totalSeats - occupiedSeats;
        }

        public boolean book(int seats) {
            if (seats <= 0 || seats > getFreeSeats()) {
                return false;
            }
            occupiedSeats += seats;
            return true;
        }

        @Override
        public String toString() {
            return "Вагон №" + carriageNumber + " (" + type + "): " + occupiedSeats + "/" + totalSeats;
        }
    }

    static class PassengerTrain {
        private final String route;
        private final TrainCarriage[] carriages;
        private int carriageCount;

        public PassengerTrain(String route, int capacity) {
            this.route = route;
            this.carriages = new TrainCarriage[Math.max(1, capacity)];
        }

        public boolean attachCarriage(TrainCarriage c) {
            if (c == null || carriageCount >= carriages.length) {
                return false;
            }
            carriages[carriageCount++] = c;
            return true;
        }

        public int getTotalFreeSeats() {
            int free = 0;
            for (int i = 0; i < carriageCount; i++) {
                free += carriages[i].getFreeSeats();
            }
            return free;
        }

        public boolean bookTicketsInCarriage(int carriageNumber, int seatsToBook) {
            for (int i = 0; i < carriageCount; i++) {
                if (carriages[i].getCarriageNumber() == carriageNumber) {
                    return carriages[i].book(seatsToBook);
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Потяг " + route + ":");
            for (int i = 0; i < carriageCount; i++) {
                sb.append("\n  ").append(carriages[i]);
            }
            return sb.toString();
        }
    }
}
