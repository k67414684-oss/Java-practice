package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task31 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task31: User -> StudentUser -> PostgraduateStudent ---");
        PostgraduateStudent good = new PostgraduateStudent(1, "olena@duikt.edu.ua", "КН-91", 92.5,
                "Методи оптимізації мобільних застосунків", "проф. Іваненко");
        PostgraduateStudent weak = new PostgraduateStudent(2, "max@duikt.edu.ua", "КН-91", 78.0,
                "Аналіз даних", "доц. Шевчук");
        PostgraduateStudent noTopic = new PostgraduateStudent(3, "ira@duikt.edu.ua", "КН-91", 90.0,
                "  ", "доц. Шевчук");
        System.out.println(good);
        System.out.println(weak);
        System.out.println(noTopic);
    }

    static class User {
        private int id;
        private String email;

        public User(int id, String email) {
            this.id = id;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "User{id=" + id + ", email='" + email + "'}";
        }
    }

    static class StudentUser extends User {
        private String groupCode;
        private double gpa;

        public StudentUser(int id, String email, String groupCode, double gpa) {
            super(id, email);
            this.groupCode = groupCode;
            this.gpa = (gpa >= 0 && gpa <= 100) ? gpa : 0.0;
        }

        public String getGroupCode() {
            return groupCode;
        }

        public double getGpa() {
            return gpa;
        }

        @Override
        public String toString() {
            return String.format("StudentUser{%s, group='%s', gpa=%.1f}", super.toString(), groupCode, gpa);
        }
    }

    static class PostgraduateStudent extends StudentUser {
        private String thesisTopic;
        private String supervisorName;

        public PostgraduateStudent(int id, String email, String groupCode, double gpa,
                                   String thesisTopic, String supervisorName) {
            super(id, email, groupCode, gpa);
            this.thesisTopic = thesisTopic;
            this.supervisorName = supervisorName;
        }

        public boolean canDefendThesis() {
            return getGpa() >= 85.0 && thesisTopic != null && !thesisTopic.isBlank();
        }

        @Override
        public String toString() {
            return String.format("PostgraduateStudent{%s, thesis='%s', supervisor='%s', допуск до захисту=%s}",
                    super.toString(), thesisTopic, supervisorName, canDefendThesis() ? "ТАК" : "НІ");
        }
    }
}
