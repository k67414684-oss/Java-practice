package practice7;

public class Task37 {

    private String name;
    private int health;
    private int attackPower;
    private int defense;

    public Task37(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public void attack(Task37 target) {
        int damage = this.attackPower - target.defense;
        if (damage <= 0) {
            damage = 1;
        }
        target.health -= damage;
        if (target.health < 0) {
            target.health = 0;
        }
        System.out.println(this.name + " б'є " + target.name + " на " + damage + " шкоди. У " + target.name + " залишилось " + target.health + " HP");
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Task37 knight = new Task37("Лицар", 100, 18, 5);
        Task37 orc = new Task37("Орк", 120, 15, 3);

        int round = 1;
        while (knight.isAlive() && orc.isAlive()) {
            System.out.println("Раунд " + round);
            knight.attack(orc);
            if (orc.isAlive()) {
                orc.attack(knight);
            }
            round++;
        }

        if (knight.isAlive()) {
            System.out.println("Переміг " + knight.getName());
        } else {
            System.out.println("Переміг " + orc.getName());
        }
    }
}
