package practice6;

public class Task11 {

    public int count;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public void reset() {
        count = 0;
    }

    public void printCount() {
        System.out.println("Лічильник: " + count);
    }

    public static void main(String[] args) {
        Task11 counter = new Task11();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.decrement();
        counter.printCount();

        counter.reset();
        counter.printCount();
    }
}
