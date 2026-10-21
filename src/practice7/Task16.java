package practice7;

public class Task16 {

    private String ticketNumber;
    private String passengerName;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private String seatNumber;
    private boolean hasBaggage;

    public Task16(String ticketNumber, String passengerName, String flightNumber, String departureCity,
                        String arrivalCity, String seatNumber, boolean hasBaggage) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.seatNumber = seatNumber;
        this.hasBaggage = hasBaggage;
    }

    public Task16(String ticketNumber, String passengerName, String flightNumber, String departureCity,
                        String arrivalCity) {
        this(ticketNumber, passengerName, flightNumber, departureCity, arrivalCity, "UNASSIGNED", false);
    }

    public void assignSeat(String seat) {
        this.seatNumber = seat;
    }

    public void printBoardingPass() {
        System.out.println("========= Посадковий талон =========");
        System.out.println("Квиток: " + ticketNumber);
        System.out.println("Пасажир: " + passengerName);
        System.out.println("Рейс: " + flightNumber);
        System.out.println("Маршрут: " + departureCity + " -> " + arrivalCity);
        System.out.println("Місце: " + seatNumber);
        if (hasBaggage) {
            System.out.println("Багаж: є");
        } else {
            System.out.println("Багаж: немає");
        }
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        Task16 ticket = new Task16("TK-1001", "Олена Коваль", "PS101", "Київ", "Львів");
        ticket.printBoardingPass();

        ticket.assignSeat("14A");
        ticket.printBoardingPass();

        Task16 ticket2 = new Task16("TK-1002", "Максим Шевченко", "PS202", "Одеса", "Київ", "3C", true);
        ticket2.printBoardingPass();
    }
}
