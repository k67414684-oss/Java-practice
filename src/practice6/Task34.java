package practice6;

public class Task34 {

    private int[] numbers;

    public void setNumbers(int[] nums) {
        numbers = nums;
    }

    public int countEvens() {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int countOdds() {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public int calculateSum() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Task34 stats = new Task34();
        int[] nums = {12, 7, 3, 28, 15, 40, 9, 22, 5, 18};
        stats.setNumbers(nums);

        System.out.println("Парних чисел: " + stats.countEvens());
        System.out.println("Непарних чисел: " + stats.countOdds());
        System.out.println("Сума всіх чисел: " + stats.calculateSum());
    }
}
