package practice6;

public class Task13 {

    public String nickname;
    public int health = 100;

    public void takeDamage(int damage) {
        health = health - damage;
        if (health < 0) {
            health = 0;
            System.out.println(nickname + " загинув!");
        }
    }

    public void heal(int amount) {
        health = health + amount;
        if (health > 100) {
            health = 100;
        }
    }

    public static void main(String[] args) {
        Task13 player = new Task13();
        player.nickname = "DragonSlayer";
        System.out.println("Здоров'я: " + player.health);

        player.takeDamage(40);
        System.out.println("Після шкоди 40: " + player.health);

        player.heal(30);
        System.out.println("Після лікування 30: " + player.health);

        player.heal(100);
        System.out.println("Після лікування 100: " + player.health);

        player.takeDamage(150);
        System.out.println("Після шкоди 150: " + player.health);
    }
}
