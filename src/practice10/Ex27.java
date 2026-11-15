package practice10;

abstract class AbstractWorker {
    protected final String name; protected final double baseSalary;
    public AbstractWorker(String name, double baseSalary) { this.name = name; this.baseSalary = baseSalary; }
    public double getBaseSalary() { return baseSalary; }
}
interface BonusEligible { double calculateQuarterBonus(); }
interface MedicalInsured { double getInsuranceCoverage(); }

class FullTimeDeveloper extends AbstractWorker implements BonusEligible, MedicalInsured {
    public FullTimeDeveloper(String name, double sal) { super(name, sal); }
    @Override public double calculateQuarterBonus() { return baseSalary * 0.25; }
    @Override public double getInsuranceCoverage() { return 100_000.0; }
}
class FopContractor extends AbstractWorker implements BonusEligible {
    public FopContractor(String name, double sal) { super(name, sal); }
    @Override public double calculateQuarterBonus() { return baseSalary * 0.15; }
}
class InternStudent extends AbstractWorker {
    public InternStudent(String name, double sal) { super(name, sal); }
}

public class Ex27 {
    public static void main(String[] args) {
        AbstractWorker[] staff = {
                new FullTimeDeveloper("Олена", 90_000),
                new FopContractor("Ігор", 80_000),
                new InternStudent("Тарас", 15_000)
        };
        double baseFund = 0, bonuses = 0;
        int insured = 0;
        for (AbstractWorker w : staff) {
            baseFund += w.getBaseSalary();
            if (w instanceof BonusEligible b) bonuses += b.calculateQuarterBonus();
            if (w instanceof MedicalInsured) insured++;
        }
        System.out.printf("Базовий фонд: %.2f | Премії: %.2f | Застраховано: %d осіб%n", baseFund, bonuses, insured);
    }
}
