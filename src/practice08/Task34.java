package practice08;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Task34 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task34: GradeSheet -> WeightedGradeSheet ---");
        int[] grades = {90, 75, 100, 60};
        double[] weights = {1, 2, 3, 1};
        GradeSheet simple = new GradeSheet("Влад", grades);
        WeightedGradeSheet weighted = new WeightedGradeSheet("Влад", grades, weights);
        System.out.println(simple);
        System.out.println(weighted);
        System.out.printf("Звичайний бал: %.2f, зважений бал: %.2f%n", simple.calculateScore(), weighted.calculateScore());
    }

    static class GradeSheet {
        private String studentName;
        protected int[] grades;

        public GradeSheet(String studentName, int[] grades) {
            this.studentName = studentName;
            if (grades == null) {
                this.grades = new int[0];
            } else {
                this.grades = Arrays.copyOf(grades, grades.length);
            }
        }

        public String getStudentName() {
            return studentName;
        }

        public double getSimpleAverage() {
            if (grades.length == 0) {
                return 0.0;
            }
            double sum = 0;
            for (int g : grades) {
                sum += g;
            }
            return sum / grades.length;
        }

        public double calculateScore() {
            return getSimpleAverage();
        }

        @Override
        public String toString() {
            return String.format("GradeSheet{student='%s', grades=%s, середній=%.2f}",
                    studentName, Arrays.toString(grades), getSimpleAverage());
        }
    }

    static class WeightedGradeSheet extends GradeSheet {
        private double[] weights;

        public WeightedGradeSheet(String studentName, int[] grades, double[] weights) {
            super(studentName, grades);
            this.weights = new double[grades.length];
            for (int i = 0; i < this.weights.length; i++) {

                if (weights != null && i < weights.length && weights[i] > 0) {
                    this.weights[i] = weights[i];
                } else {
                    this.weights[i] = 1.0;
                }
            }
        }

        @Override
        public double calculateScore() {
            double weightedSum = 0;
            double weightsSum = 0;
            for (int i = 0; i < grades.length; i++) {
                weightedSum += grades[i] * weights[i];
                weightsSum += weights[i];
            }
            if (weightsSum == 0) {
                return 0.0;
            }
            return weightedSum / weightsSum;
        }

        @Override
        public String toString() {
            return String.format("WeightedGradeSheet{%s, weights=%s, зважений бал=%.2f}",
                    super.toString(), Arrays.toString(weights), calculateScore());
        }
    }
}
