package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task13 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task13: Person -> UniversityStudent, Professor ---");
        UniversityStudent student = new UniversityStudent("Влад Петренко", 2008, "ST-2026-01", "Комп'ютерні науки", 1700);
        Professor professor = new Professor("Олена Коваль", 1975, "доцент", 34);
        System.out.println(student);
        System.out.println("Вік студента у 2026: " + student.getAge(2026));
        System.out.println(professor);
        System.out.println("Вік професора у 2026: " + professor.getAge(2026));
    }

    static class Person {
        private String fullName;
        private int birthYear;

        public Person(String fullName, int birthYear) {
            this.fullName = fullName;
            this.birthYear = birthYear;
        }

        public String getFullName() {
            return fullName;
        }

        public int getBirthYear() {
            return birthYear;
        }

        public int getAge(int currentYear) {
            return currentYear - birthYear;
        }

        @Override
        public String toString() {
            return "Person{fullName='" + fullName + "', birthYear=" + birthYear + "}";
        }
    }

    static class UniversityStudent extends Person {
        private String studentId;
        private String major;
        private int scholarship;

        public UniversityStudent(String fullName, int birthYear, String studentId, String major, int scholarship) {
            super(fullName, birthYear);
            this.studentId = studentId;
            this.major = major;
            this.scholarship = Math.max(0, scholarship);
        }

        public String getStudentId() {
            return studentId;
        }

        public String getMajor() {
            return major;
        }

        public int getScholarship() {
            return scholarship;
        }

        @Override
        public String toString() {
            return "UniversityStudent{" + super.toString() + ", id='" + studentId + "', major='" + major
                    + "', scholarship=" + scholarship + " грн}";
        }
    }

    static class Professor extends Person {
        private String academicTitle;
        private int publicationsCount;

        public Professor(String fullName, int birthYear, String academicTitle, int publicationsCount) {
            super(fullName, birthYear);
            this.academicTitle = academicTitle;
            this.publicationsCount = Math.max(0, publicationsCount);
        }

        public String getAcademicTitle() {
            return academicTitle;
        }

        public int getPublicationsCount() {
            return publicationsCount;
        }

        @Override
        public String toString() {
            return "Professor{" + super.toString() + ", title='" + academicTitle
                    + "', publications=" + publicationsCount + "}";
        }
    }
}
