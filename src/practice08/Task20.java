package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task20 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task20: Weapon -> EnchantedSword ---");
        Weapon dagger = new Weapon("Звичайний кинджал", 35);
        EnchantedSword sword = new EnchantedSword("Меч Світанку", 60, "вогонь", 12, 5);
        System.out.println(dagger);
        System.out.println(sword);
    }

    static class Weapon {
        private String title;
        private int baseDamage;

        public Weapon(String title, int baseDamage) {
            this.title = title;
            this.baseDamage = Math.max(0, baseDamage);
        }

        public String getTitle() {
            return title;
        }

        public int getBaseDamage() {
            return baseDamage;
        }

        public int calculateDamage() {
            return baseDamage;
        }

        @Override
        public String toString() {
            return "Weapon{title='" + title + "', damage=" + calculateDamage() + "}";
        }
    }

    static class EnchantedSword extends Weapon {
        private String element;
        private int magicPower;
        private int enchantmentLevel;

        public EnchantedSword(String title, int baseDamage, String element, int magicPower, int enchantmentLevel) {
            super(title, baseDamage);
            this.element = element;
            this.magicPower = Math.max(0, magicPower);
            this.enchantmentLevel = Math.max(0, enchantmentLevel);
        }

        public int getMagicDamage() {
            return magicPower * enchantmentLevel;
        }

        @Override
        public int calculateDamage() {
            return super.calculateDamage() + magicPower * enchantmentLevel;
        }

        @Override
        public String toString() {
            return String.format("EnchantedSword{title='%s', element=%s, фізична=%d, магічна=%d (%d x %d), всього=%d}",
                    getTitle(), element, getBaseDamage(), getMagicDamage(), magicPower, enchantmentLevel, calculateDamage());
        }
    }
}
