package practice6;

public class Task37 {

    private int[] data;

    public void setData(int[] data) {
        this.data = data;
    }

    public boolean contains(int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return true;
            }
        }
        return false;
    }

    public int findIndex(int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task37 searcher = new Task37();
        int[] numbers = {4, 8, 15, 16, 23, 42, 8};
        searcher.setData(numbers);

        System.out.println("Число 23 є в масиві: " + searcher.contains(23));
        System.out.println("Індекс числа 23: " + searcher.findIndex(23));
        System.out.println("Індекс числа 8: " + searcher.findIndex(8));
        System.out.println("Число 100 є в масиві: " + searcher.contains(100));
        System.out.println("Індекс числа 100: " + searcher.findIndex(100));
    }
}
