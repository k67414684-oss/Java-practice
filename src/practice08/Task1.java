package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task1 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task1: Student ---");
        Student student = new Student("Влад", 1, 87.5);
        System.out.println(student);
        Student wrong = new Student("Тест", 9, 150);
        System.out.println("Некоректні дані конструктора -> " + wrong);
        student.setCourse(-3);
        student.setGpa(-10);
        System.out.println("Після поганих сеттерів      -> " + student);
    }

    static class Student {
        private String name;
        private int course;
        private double gpa;

        public Student(String name, int course, double gpa) {
            this.name = name;

            setCourse(course);
            setGpa(gpa);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCourse() {
            return course;
        }

        public final void setCourse(int course) {
            if (course >= 1 && course <= 6) {
                this.course = course;
            } else {
                this.course = 1;
            }
        }

        public double getGpa() {
            return gpa;
        }

        public final void setGpa(double gpa) {
            if (gpa >= 0.0 && gpa <= 100.0) {
                this.gpa = gpa;
            } else {
                this.gpa = 60.0;
            }
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', course=" + course + ", gpa=" + gpa + "}";
        }
    }
}
