package practice6;

public class Task9 {

    public void sayHello() {
        System.out.println("Привіт усім!");
    }

    public void sayHelloTo(String name) {
        System.out.println("Привіт, " + name + "! Раді тебе бачити.");
    }

    public static void main(String[] args) {
        Task9 greeter = new Task9();
        greeter.sayHello();
        greeter.sayHelloTo("Олена");
        greeter.sayHelloTo("Максим");
    }
}
