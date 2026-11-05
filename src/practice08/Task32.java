package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task32 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task32: Medicine -> PrescriptionMedicine -> ControlledSubstance ---");
        Medicine vitamin = new Medicine("Вітамін C", 120, false);
        PrescriptionMedicine antibiotic = new PrescriptionMedicine("Амоксиклав", 310, false, "LIC-5521");
        ControlledSubstance painkiller = new ControlledSubstance("Трамадол", 450, false, "LIC-9034", 17);
        ControlledSubstance adultPainkiller = new ControlledSubstance("Трамадол", 450, false, "LIC-9034", 35);
        ControlledSubstance expired = new ControlledSubstance("Трамадол", 450, true, "LIC-9034", 35);
        System.out.println(vitamin);
        System.out.println(antibiotic + " -> з рецептом: " + antibiotic.canSell(true)
                + ", без рецепта: " + antibiotic.canSell(false));
        System.out.println(painkiller + " -> з рецептом: " + painkiller.canSell(true));
        System.out.println(adultPainkiller + " -> з рецептом: " + adultPainkiller.canSell(true));
        System.out.println(expired + " -> з рецептом: " + expired.canSell(true));
    }

    static class Medicine {
        private String name;
        private double price;
        private boolean expired;

        public Medicine(String name, double price, boolean expired) {
            this.name = name;
            this.price = Math.max(0.0, price);
            this.expired = expired;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public boolean isExpired() {
            return expired;
        }

        @Override
        public String toString() {
            return String.format("Medicine{name='%s', price=%.2f, прострочено=%s}", name, price, expired ? "так" : "ні");
        }
    }

    static class PrescriptionMedicine extends Medicine {
        private String doctorLicense;

        public PrescriptionMedicine(String name, double price, boolean expired, String doctorLicense) {
            super(name, price, expired);
            this.doctorLicense = doctorLicense;
        }

        public String getDoctorLicense() {
            return doctorLicense;
        }

        public boolean canSell(boolean hasPrescription) {
            return !isExpired() && hasPrescription;
        }

        @Override
        public String toString() {
            return "PrescriptionMedicine{" + super.toString() + ", doctorLicense='" + doctorLicense + "'}";
        }
    }

    static class ControlledSubstance extends PrescriptionMedicine {
        private int patientAge;

        public ControlledSubstance(String name, double price, boolean expired, String doctorLicense, int patientAge) {
            super(name, price, expired, doctorLicense);
            this.patientAge = patientAge;
        }

        public int getPatientAge() {
            return patientAge;
        }

        @Override
        public boolean canSell(boolean hasPrescription) {
            return super.canSell(hasPrescription) && patientAge >= 18;
        }

        @Override
        public String toString() {
            return "ControlledSubstance{" + super.toString() + ", patientAge=" + patientAge + "}";
        }
    }
}
