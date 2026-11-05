package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Task8 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task8: MedicalRecord ---");
        String[] allergies = {"Пеніцилін", "Горіхи"};
        MedicalRecord record = new MedicalRecord("P-0001", "Іван Петренко", 2, true, allergies);
        allergies[0] = "Нічого";
        System.out.println(record);
        System.out.println("Алергія на пеніцилін: " + record.hasAllergyTo("пеніцилін"));
        System.out.println("Алергія на мед:       " + record.hasAllergyTo("мед"));
        record.getAllergies()[1] = "Хакер";
        System.out.println(record);
    }

    static class MedicalRecord {
        private final String patientId;
        private final String fullName;
        private final int bloodGroup;
        private final boolean rhPositive;
        private final String[] allergies;

        public MedicalRecord(String patientId, String fullName, int bloodGroup, boolean rhPositive, String[] allergies) {
            this.patientId = patientId;
            this.fullName = fullName;
            this.bloodGroup = Math.max(1, Math.min(4, bloodGroup));
            this.rhPositive = rhPositive;
            this.allergies = allergies == null ? new String[0] : Arrays.copyOf(allergies, allergies.length);
        }

        public String[] getAllergies() {
            return Arrays.copyOf(allergies, allergies.length);
        }

        public boolean hasAllergyTo(String substance) {
            for (String allergy : allergies) {
                if (allergy.equalsIgnoreCase(substance)) {
                    return true;
                }
            }
            return false;
        }

        private String bloodGroupText() {
            String[] names = {"I (O)", "II (A)", "III (B)", "IV (AB)"};
            return names[bloodGroup - 1] + " Rh" + (rhPositive ? "+" : "-");
        }

        @Override
        public String toString() {
            return "MedicalRecord{id='" + patientId + "', name='" + fullName + "', кров: " + bloodGroupText()
                    + ", алергії: " + Arrays.toString(allergies) + "}";
        }
    }
}
