package practice7;

public class Task24 {

    public int[] filter(int[] arr, int threshold) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > threshold) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > threshold) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    public int[] filter(int[] arr, int min, int max) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    public int[] filter(int[] arr, boolean keepEvens) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isEven = arr[i] % 2 == 0;
            if (isEven == keepEvens) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isEven = arr[i] % 2 == 0;
            if (isEven == keepEvens) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Task24 filter = new Task24();
        int[] numbers = {12, 5, 8, 19, 24, 3, 16};

        System.out.print("Більші за 10: ");
        printArray(filter.filter(numbers, 10));

        System.out.print("У діапазоні [5; 16]: ");
        printArray(filter.filter(numbers, 5, 16));

        System.out.print("Парні: ");
        printArray(filter.filter(numbers, true));

        System.out.print("Непарні: ");
        printArray(filter.filter(numbers, false));
    }
}
