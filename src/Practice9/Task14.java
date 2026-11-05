package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task14 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task14: HeroCharacter + WeaponItem ---");
        HeroCharacter hero = new HeroCharacter("Arthas", 50);
        System.out.println("Атака без зброї: " + hero.attack());
        hero.equip(new WeaponItem("Frostmourne", 40, 30));
        for (int i = 1; i <= 4; i++) {
            System.out.println("Удар " + i + ": " + hero.attack() + "  " + hero);
        }
        hero.equip(new WeaponItem("Меч новачка", 10, 100));
        System.out.println("Нова зброя: " + hero.attack() + "  " + hero);
        hero.unequip();
        System.out.println("Без зброї: " + hero.attack() + "  " + hero);
    }

    static class WeaponItem {
        private final String name;
        private final int bonusDamage;
        private int durability;

        public WeaponItem(String name, int bonusDamage, int durability) {
            this.name = name;
            this.bonusDamage = Math.max(0, bonusDamage);
            this.durability = Math.max(0, Math.min(100, durability));
        }

        public int useWeapon() {
            int bonus = durability == 0 ? 0 : bonusDamage;
            durability = Math.max(0, durability - 10);
            return bonus;
        }

        @Override
        public String toString() {
            return name + "(+" + bonusDamage + ", міцність " + durability + ")";
        }
    }

    static class HeroCharacter {
        private final String nickname;
        private int baseStrength;
        private WeaponItem equippedWeapon;

        public HeroCharacter(String nickname, int baseStrength) {
            this.nickname = nickname;
            this.baseStrength = Math.max(1, baseStrength);
        }

        public void equip(WeaponItem newWeapon) {
            equippedWeapon = newWeapon;
        }

        public void unequip() {
            equippedWeapon = null;
        }

        public int attack() {
            int bonus = equippedWeapon != null ? equippedWeapon.useWeapon() : 0;
            return baseStrength + bonus;
        }

        @Override
        public String toString() {
            return "HeroCharacter{" + nickname + ", сила " + baseStrength + ", зброя: "
                    + (equippedWeapon == null ? "немає" : equippedWeapon) + "}";
        }
    }
}
