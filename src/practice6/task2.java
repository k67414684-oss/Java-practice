package practice6;

public class task2 {


    public static class Car {
        public String brand;
        public String model;
        public int year;
        public int speed;

        public static void main(String[] args) {
            Car car1 = new Car();
            Car car2 = new Car();

            car1.brand = "Toyota";
            car1.model = "Camry";
            car1.speed = 2021;
            car1.year = 180;

            car2.brand = "BMW";
            car2.model = "M5";
            car2.speed = 2023;
            car2.year = 250;

            System.out.println("Car 1:" + car1.brand + ", " + car1.model + ", " + car1.speed + ", " + car1.year);
            System.out.println("Car 2:" + car2.brand + ", " + car2.model + ", " + car2.speed + ", " + car2.year);


        }


    }

}
