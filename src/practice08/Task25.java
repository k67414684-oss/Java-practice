package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task25 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task25: DotaHero -> StrengthHero -> AlchemistHero ---");
        DotaHero base = new DotaHero("Invoker", "Універсал", 600);
        StrengthHero tiny = new StrengthHero("Tiny", 620, 30);
        AlchemistHero alchemist = new AlchemistHero("Alchemist", 640, 28, 150);
        System.out.println(base);
        System.out.println(tiny);
        System.out.println(alchemist);
        System.out.println(alchemist.chemicalRage());
    }

    static class DotaHero {
        private String name;
        private String primaryAttribute;
        private int baseHp;

        public DotaHero(String name, String primaryAttribute, int baseHp) {
            this.name = name;
            this.primaryAttribute = primaryAttribute;
            this.baseHp = Math.max(1, baseHp);
        }

        public String getName() {
            return name;
        }

        public String getPrimaryAttribute() {
            return primaryAttribute;
        }

        public int getBaseHp() {
            return baseHp;
        }

        public int getMaxHp() {
            return baseHp;
        }

        @Override
        public String toString() {
            return "DotaHero{name='" + name + "', attribute=" + primaryAttribute + ", maxHp=" + getMaxHp() + "}";
        }
    }

    static class StrengthHero extends DotaHero {
        private int strength;

        public StrengthHero(String name, int baseHp, int strength) {
            super(name, "Сила", baseHp);
            this.strength = Math.max(0, strength);
        }

        public int getStrength() {
            return strength;
        }

        @Override
        public int getMaxHp() {
            return super.getMaxHp() + strength * 22;
        }

        @Override
        public String toString() {
            return "StrengthHero{" + super.toString() + ", strength=" + strength + "}";
        }
    }

    static class AlchemistHero extends StrengthHero {
        private int greevilsGreedBonusGold;

        public AlchemistHero(String name, int baseHp, int strength, int greevilsGreedBonusGold) {
            super(name, baseHp, strength);
            this.greevilsGreedBonusGold = Math.max(0, greevilsGreedBonusGold);
        }

        public String chemicalRage() {
            return getName() + " вмикає Chemical Rage! Швидкість атаки зростає, HP відновлюється швидше.";
        }

        @Override
        public String toString() {
            return "AlchemistHero{" + super.toString() + ", greevilsGreedBonusGold=" + greevilsGreedBonusGold + "}";
        }
    }
}
