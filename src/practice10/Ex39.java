package practice10;

abstract class AbstractCombatUnit {
    private final String name;
    protected int hp;
    public AbstractCombatUnit(String name, int hp) { this.name = name; this.hp = hp; }
    public String getName() { return name; }
    public final boolean isAlive() { return hp > 0; }
    public abstract int calculateDamage();
}
interface CriticalStriker { double getCritMultiplier(); }
interface SelfRegenerating { int regenerateHp(); }
interface ShieldBearer { int absorbDamage(int incoming); }

class BerserkerAssasin extends AbstractCombatUnit implements CriticalStriker {
    public BerserkerAssasin(String name) { super(name, 120); }
    @Override public int calculateDamage() { return 40; }
    @Override public double getCritMultiplier() { return 2.0; }
}
class TrollWarlord extends AbstractCombatUnit implements CriticalStriker, SelfRegenerating {
    public TrollWarlord(String name) { super(name, 200); }
    @Override public int calculateDamage() { return 35; }
    @Override public double getCritMultiplier() { return 1.5; }
    @Override public int regenerateHp() { hp += 15; return 15; }
}
class RoyalPaladin extends AbstractCombatUnit implements ShieldBearer, SelfRegenerating {
    public RoyalPaladin(String name) { super(name, 220); }
    @Override public int calculateDamage() { return 30; }
    @Override public int absorbDamage(int incoming) { return (int) (incoming * 0.6); }
    @Override public int regenerateHp() { hp += 10; return 10; }
}

public class Ex39 {
    public static void main(String[] args) {
        AbstractCombatUnit[] units = { new BerserkerAssasin("Рагнар"), new TrollWarlord("Гром"), new RoyalPaladin("Утер") };
        for (AbstractCombatUnit u : units) {
            if (u instanceof SelfRegenerating reg) System.out.println(u.getName() + " регенерував +" + reg.regenerateHp() + " HP");
            int dmg = u.calculateDamage();
            if (u instanceof CriticalStriker crit) dmg = (int) (dmg * crit.getCritMultiplier());
            System.out.println(u.getName() + " атакує на " + dmg + " шкоди (Живий: " + u.isAlive() + ")");
        }
    }
}
