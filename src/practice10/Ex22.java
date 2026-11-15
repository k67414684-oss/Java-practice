package practice10;

abstract class AbstractMilitaryUnit {
    private final String unitName;
    protected int hp;
    public AbstractMilitaryUnit(String unitName, int hp) { this.unitName = unitName; this.hp = hp; }
    public String getUnitName() { return unitName; }
    public abstract int getMoveSpeed();
}
interface RangedAttacker { int getAttackRange(); int fireShot(); }
interface FieldHealer { int healAlly(); }

class HeavySniper extends AbstractMilitaryUnit implements RangedAttacker {
    public HeavySniper(String name) { super(name, 100); }
    @Override public int getMoveSpeed() { return 4; }
    @Override public int getAttackRange() { return 12; }
    @Override public int fireShot() { return 85; }
}
class CombatMedic extends AbstractMilitaryUnit implements FieldHealer {
    public CombatMedic(String name) { super(name, 110); }
    @Override public int getMoveSpeed() { return 6; }
    @Override public int healAlly() { return 40; }
}
class PaladinCaptain extends AbstractMilitaryUnit implements RangedAttacker, FieldHealer {
    public PaladinCaptain(String name) { super(name, 180); }
    @Override public int getMoveSpeed() { return 5; }
    @Override public int getAttackRange() { return 6; }
    @Override public int fireShot() { return 55; }
    @Override public int healAlly() { return 30; }
}

public class Ex22 {
    public static void main(String[] args) {
        AbstractMilitaryUnit[] army = { new HeavySniper("Привид"), new CombatMedic("Док"), new PaladinCaptain("Артур") };
        for (AbstractMilitaryUnit u : army) {
            System.out.print(u.getUnitName() + " (швидкість " + u.getMoveSpeed() + "): ");
            if (u instanceof RangedAttacker ra) System.out.print("атака=" + ra.fireShot() + " ");
            if (u instanceof FieldHealer fh) System.out.print("лікування=" + fh.healAlly());
            System.out.println();
        }
    }
}
