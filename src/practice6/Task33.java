package practice6;

public class Task33 {

    private String studentName;
    private int[] grades;

    public void setData(String name, int[] g) {
        studentName = name;
        grades = g;
    }

    public double getAverage() {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return (double) sum / grades.length;
    }

    public int getHighestGrade() {
        int max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public int getLowestGrade() {
        int min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Task33 gradeBook = new Task33();
        int[] grades = {85, 92, 78, 96, 65};
        gradeBook.setData("Денис", grades);

        System.out.println("Середній бал: " + gradeBook.getAverage());
        System.out.println("Найвища оцінка: " + gradeBook.getHighestGrade());
        System.out.println("Найнижча оцінка: " + gradeBook.getLowestGrade());
    }
}
