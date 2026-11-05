package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task38 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task38: Employee -> Developer -> TeamLead ---");
        TeamLead lead = new TeamLead("Марія", 60000, "Java", 3);
        lead.addTeamMember(new Developer("Polina", 20000, "Java"));
        lead.addTeamMember(new Developer("Олег", 22000, "Kotlin"));
        lead.addTeamMember(new Developer("Іван", 18000, "Python"));
        lead.addTeamMember(new Developer("Зайвий", 15000, "C#"));
        System.out.println(lead);
    }

    static class Employee {
        private String name;
        protected double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = Math.max(0.0, salary);
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return String.format("Employee{name='%s', salary=%.2f}", name, salary);
        }
    }

    static class Developer extends Employee {
        private String programmingLanguage;

        public Developer(String name, double salary, String programmingLanguage) {
            super(name, salary);
            this.programmingLanguage = programmingLanguage;
        }

        public String getProgrammingLanguage() {
            return programmingLanguage;
        }

        @Override
        public String toString() {
            return String.format("Developer{%s, language='%s'}", super.toString(), programmingLanguage);
        }
    }

    static class TeamLead extends Developer {
        private Developer[] teamMembers;
        private int memberCount;

        public TeamLead(String name, double salary, String programmingLanguage, int maxTeamSize) {
            super(name, salary, programmingLanguage);
            this.teamMembers = new Developer[Math.max(1, maxTeamSize)];
            this.memberCount = 0;
        }

        public void addTeamMember(Developer dev) {
            if (dev == null) {
                return;
            }
            if (memberCount >= teamMembers.length) {
                System.out.println("  Команда заповнена, не вдалося додати: " + dev.getName());
                return;
            }
            teamMembers[memberCount] = dev;
            memberCount++;
        }

        public int getMemberCount() {
            return memberCount;
        }

        public double getTotalTeamBudget() {
            double total = getSalary();
            for (int i = 0; i < memberCount; i++) {
                total += teamMembers[i].getSalary();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TeamLead{").append(super.toString()).append("}\n");
            sb.append(String.format("  Загальний бюджет команди: %.2f грн%n", getTotalTeamBudget()));
            sb.append("  Учасники команди (").append(memberCount).append("/").append(teamMembers.length).append("):");
            for (int i = 0; i < memberCount; i++) {
                sb.append("\n    ").append(i + 1).append(". ").append(teamMembers[i]);
            }
            return sb.toString();
        }
    }
}
