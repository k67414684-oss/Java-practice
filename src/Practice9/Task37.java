package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task37 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task37: RaidParty ---");
        RaidParty party = new RaidParty("Dragon Slayers", 5);
        party.addMember(new ArcaneMage("Merlin", 600, 90, 70));
        party.addMember(new ArcaneMage("Jaina", 650, 95, 80));
        System.out.println(party);
        System.out.println("Готовність до рейду (складність 600): " + party.isReadyForRaid(600));
        party.addMember(new TankWarrior("Thorin", 1800, 60));
        System.out.println(party);
        System.out.println("Готовність до рейду (складність 600): " + party.isReadyForRaid(600));
        System.out.println("Готовність до рейду (складність 2000): " + party.isReadyForRaid(2000));
    }

    static abstract class AbstractHeroUnit {
        private final String name;
        protected int hp;

        public AbstractHeroUnit(String name, int hp) {
            this.name = name;
            this.hp = Math.max(1, hp);
        }

        public abstract int getCombatPower();

        public abstract String getRole();

        @Override
        public String toString() {
            return String.format("%s{%s, роль %s, HP %d, сила %d}", getClass().getSimpleName(), name, getRole(), hp,
                    getCombatPower());
        }
    }

    static class TankWarrior extends AbstractHeroUnit {
        private final int armor;

        public TankWarrior(String name, int hp, int armor) {
            super(name, hp);
            this.armor = Math.max(0, armor);
        }

        @Override
        public int getCombatPower() {
            return hp / 10 + armor * 5;
        }

        @Override
        public String getRole() {
            return "Tank";
        }
    }

    static class ArcaneMage extends AbstractHeroUnit {
        private final int intelligence;
        private final int spellPower;

        public ArcaneMage(String name, int hp, int intelligence, int spellPower) {
            super(name, hp);
            this.intelligence = Math.max(0, intelligence);
            this.spellPower = Math.max(0, spellPower);
        }

        @Override
        public int getCombatPower() {
            return intelligence * 3 + spellPower * 2;
        }

        @Override
        public String getRole() {
            return "Mage";
        }
    }

    static class RaidParty {
        private final String guildName;
        private final AbstractHeroUnit[] members;
        private int memberCount;

        public RaidParty(String guildName, int capacity) {
            this.guildName = guildName;
            this.members = new AbstractHeroUnit[Math.max(1, capacity)];
        }

        public boolean addMember(AbstractHeroUnit unit) {
            if (unit == null || memberCount >= members.length) {
                return false;
            }
            members[memberCount++] = unit;
            return true;
        }

        public int getTotalCombatPower() {
            int total = 0;
            for (int i = 0; i < memberCount; i++) {
                total += members[i].getCombatPower();
            }
            return total;
        }

        public boolean isReadyForRaid(int dungeonDifficulty) {
            boolean hasTank = false;
            for (int i = 0; i < memberCount; i++) {
                if (members[i].getRole().equals("Tank")) {
                    hasTank = true;
                }
            }
            return hasTank && getTotalCombatPower() > dungeonDifficulty;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Гільдія '" + guildName + "':");
            for (int i = 0; i < memberCount; i++) {
                sb.append("\n  ").append(members[i]);
            }
            sb.append("\n  Сумарна сила загону: ").append(getTotalCombatPower());
            return sb.toString();
        }
    }
}
