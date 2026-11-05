package Practice9;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Task22 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        System.out.println("--- Task22: UniversityCourse ---");
        UniversityCourse course = new UniversityCourse("Програмування на Java", 5);
        course.addModule(new CourseModule("Основи", 30, 30, 20));
        course.addModule(new CourseModule("ООП", 30, 45, 40));
        System.out.println(course);
        System.out.println("Сума балів = 100: " + course.isScoreComplete());
        course.addModule(new CourseModule("Проєкт", 15, 30, 40));
        System.out.println(course);
        System.out.println("Сума балів = 100: " + course.isScoreComplete());
    }

    static class CourseModule {
        private final String topic;
        private final int lectureHours;
        private final int practiceHours;
        private final double maxScore;

        public CourseModule(String topic, int lectureHours, int practiceHours, double maxScore) {
            this.topic = topic;
            this.lectureHours = Math.max(0, lectureHours);
            this.practiceHours = Math.max(0, practiceHours);
            this.maxScore = Math.max(0.0, maxScore);
        }

        public int getTotalHours() {
            return lectureHours + practiceHours;
        }

        public double getMaxScore() {
            return maxScore;
        }

        @Override
        public String toString() {
            return topic + " (" + lectureHours + " лек. + " + practiceHours + " практ., макс. " + maxScore + " балів)";
        }
    }

    static class UniversityCourse {
        private final String courseTitle;
        private final CourseModule[] modules;
        private int moduleCount;

        public UniversityCourse(String courseTitle, int capacity) {
            this.courseTitle = courseTitle;
            this.modules = new CourseModule[Math.max(1, capacity)];
        }

        public boolean addModule(CourseModule module) {
            if (module == null || moduleCount >= modules.length) {
                return false;
            }
            modules[moduleCount++] = module;
            return true;
        }

        public double getEctsCredits() {
            int hours = 0;
            for (int i = 0; i < moduleCount; i++) {
                hours += modules[i].getTotalHours();
            }
            return hours / 30.0;
        }

        public double getTotalMaxScore() {
            double sum = 0;
            for (int i = 0; i < moduleCount; i++) {
                sum += modules[i].getMaxScore();
            }
            return sum;
        }

        public boolean isScoreComplete() {
            return Math.abs(getTotalMaxScore() - 100.0) < 1e-9;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Курс '" + courseTitle + "':");
            for (int i = 0; i < moduleCount; i++) {
                sb.append("\n  ").append(i + 1).append(". ").append(modules[i]);
            }
            sb.append(String.format("%n  Кредитів ЄКТС: %.2f, сума балів: %.1f", getEctsCredits(), getTotalMaxScore()));
            return sb.toString();
        }
    }
}
