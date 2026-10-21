package practice7;

public class Task21 {

    public int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int find(int[] arr, int target, int startIndex) {
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int find(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public int find(String[] arr, String target, boolean ignoreCase) {
        for (int i = 0; i < arr.length; i++) {
            if (ignoreCase) {
                if (arr[i].equalsIgnoreCase(target)) {
                    return i;
                }
            } else {
                if (arr[i].equals(target)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task21 searcher = new Task21();
        int[] numbers = {4, 8, 15, 16, 23, 42, 8};
        String[] words = {"apple", "Banana", "cherry", "date"};

        System.out.println("Число 8: " + searcher.find(numbers, 8));
        System.out.println("Число 8 починаючи з індексу 2: " + searcher.find(numbers, 8, 2));
        System.out.println("Число 100: " + searcher.find(numbers, 100));
        System.out.println("Слово cherry: " + searcher.find(words, "cherry"));
        System.out.println("Слово banana: " + searcher.find(words, "banana"));
        System.out.println("Слово banana без урахування регістру: " + searcher.find(words, "banana", true));
        System.out.println("Слово banana з урахуванням регістру: " + searcher.find(words, "banana", false));
    }
}
