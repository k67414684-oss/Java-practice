package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task39 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task39: CharacterUnit -> ShieldedPaladin ---");
        CharacterUnit warrior = new CharacterUnit("Воїн", 100, 5);
        ShieldedPaladin paladin = new ShieldedPaladin("Паладин", 100, 5, 40);
        System.out.println(warrior);
        System.out.println(paladin);
        System.out.println(">> Обидва отримують удар силою 30");
        warrior.takeDamage(30);
        paladin.takeDamage(30);
        System.out.println(warrior);
        System.out.println(paladin);
        System.out.println(">> Паладин отримує удар силою 50 (щит уже пробито)");
        paladin.takeDamage(50);
        System.out.println(paladin);
    }

    static class CharacterUnit {
        private String name;
        protected int hp;
        protected int maxHp;
        protected int armor;

        public CharacterUnit(String name, int maxHp, int armor) {
            this.name = name;
            this.maxHp = Math.max(1, maxHp);
            this.hp = this.maxHp;
            this.armor = Math.max(0, armor);
        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public void takeDamage(int rawDamage) {
            int damage = Math.max(1, rawDamage - armor);
            hp = Math.max(0, hp - damage);
        }

        protected String buildHealthBar() {
            int filled = (int) Math.round(10.0 * hp / maxHp);
            if (hp > 0 && filled == 0) {
                filled = 1;
            }
            StringBuilder bar = new StringBuilder("[");
            for (int i = 0; i < 10; i++) {
                bar.append(i < filled ? "█" : "░");
            }
            return bar.append("]").toString();
        }

        @Override
        public String toString() {
            return String.format("CharacterUnit{name='%s', HP=%s %d/%d, armor=%d}",
                    name, buildHealthBar(), hp, maxHp, armor);
        }
    }

    static class ShieldedPaladin extends CharacterUnit {
        private int shieldPoints;

        public ShieldedPaladin(String name, int maxHp, int armor, int shieldPoints) {
            super(name, maxHp, armor);
            this.shieldPoints = Math.max(0, shieldPoints);
        }

        public int getShieldPoints() {
            return shieldPoints;
        }

        @Override
        public void takeDamage(int rawDamage) {
            if (shieldPoints >= rawDamage) {
                shieldPoints -= rawDamage;
                return;
            }
            int remainingDamage = rawDamage - shieldPoints;
            shieldPoints = 0;
            super.takeDamage(remainingDamage);
        }

        @Override
        public String toString() {
            return String.format("ShieldedPaladin{%s, shield=%d}", super.toString(), shieldPoints);
        }
    }
}
