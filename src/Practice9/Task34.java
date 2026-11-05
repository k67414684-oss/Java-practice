package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task34 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task34: Spacecraft ---");
        Spacecraft ship = new Spacecraft("Хоробрий-1", 12.5, 4);
        ship.addThruster(new ChemicalThruster("C-1", 150, 25));
        ship.addThruster(new ChemicalThruster("C-2", 150, 25));
        ship.addThruster(new IonThruster("I-1", 0.5, 0.01));
        System.out.println(ship);
    }

    static abstract class AbstractThruster {
        private final String thrusterId;

        public AbstractThruster(String thrusterId) {
            this.thrusterId = thrusterId;
        }

        public abstract double getThrustKn();

        public abstract double getFuelBurnRate();

        @Override
        public String toString() {
            return String.format("%s{%s, тяга %.2f кН, витрата палива %.2f}", getClass().getSimpleName(), thrusterId,
                    getThrustKn(), getFuelBurnRate());
        }
    }

    static class ChemicalThruster extends AbstractThruster {
        private final double thrustKn;
        private final double burnRate;

        public ChemicalThruster(String thrusterId, double thrustKn, double burnRate) {
            super(thrusterId);
            this.thrustKn = Math.max(0.0, thrustKn);
            this.burnRate = Math.max(0.0, burnRate);
        }

        @Override
        public double getThrustKn() {
            return thrustKn;
        }

        @Override
        public double getFuelBurnRate() {
            return burnRate;
        }
    }

    static class IonThruster extends AbstractThruster {
        private final double thrustKn;
        private final double burnRate;

        public IonThruster(String thrusterId, double thrustKn, double burnRate) {
            super(thrusterId);
            this.thrustKn = Math.max(0.0, thrustKn);
            this.burnRate = Math.max(0.0, burnRate);
        }

        @Override
        public double getThrustKn() {
            return thrustKn;
        }

        @Override
        public double getFuelBurnRate() {
            return burnRate;
        }
    }

    static class Spacecraft {
        private final String shipName;
        private final double dryMassTons;
        private final AbstractThruster[] thrusters;
        private int count;

        public Spacecraft(String shipName, double dryMassTons, int capacity) {
            this.shipName = shipName;
            this.dryMassTons = dryMassTons > 0 ? dryMassTons : 1.0;
            this.thrusters = new AbstractThruster[Math.max(1, capacity)];
        }

        public boolean addThruster(AbstractThruster thruster) {
            if (thruster == null || count >= thrusters.length) {
                return false;
            }
            thrusters[count++] = thruster;
            return true;
        }

        public double getTotalThrustKn() {
            double total = 0;
            for (int i = 0; i < count; i++) {
                total += thrusters[i].getThrustKn();
            }
            return total;
        }

        public double getInitialAcceleration() {
            return getTotalThrustKn() / dryMassTons;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Spacecraft{" + shipName + ", суха маса " + dryMassTons + " т");
            for (int i = 0; i < count; i++) {
                sb.append("\n  ").append(thrusters[i]);
            }
            sb.append(String.format("%n  Сумарна тяга: %.2f кН, початкове прискорення: %.2f м/с2}",
                    getTotalThrustKn(), getInitialAcceleration()));
            return sb.toString();
        }
    }
}
