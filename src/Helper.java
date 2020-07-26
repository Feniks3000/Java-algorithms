import java.util.Arrays;
import java.util.Random;

public class Helper {
    public static int[] createRandomArray(int count, int bound) {
        long startTime = System.nanoTime();
        Random random = new Random();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(100);
        }
        long finishTime = System.nanoTime();
        System.out.println(String.format("Массив из %d случайных чисел получен за %d наносекунд", count, (finishTime - startTime)));
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        long startTime = System.nanoTime();
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        for (int i = arrayToSort.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int tmp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = tmp;
                }
            }
        }
        long finishTime = System.nanoTime();
        System.out.println(String.format("Массив из %d элементов отсортирован пузырьковым методом за %d наносекунд", arrayToSort.length, (finishTime - startTime)));
        return arrayToSort;
    }

    public static int[] selectionSort(int[] array) {
        long startTime = System.nanoTime();
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        for (int i = 0; i < arrayToSort.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = arrayToSort[i];
                arrayToSort[i] = arrayToSort[min];
                arrayToSort[min] = tmp;
            }
        }
        long finishTime = System.nanoTime();
        System.out.println(String.format("Массив из %d элементов отсортирован методом выбора за %d наносекунд", arrayToSort.length, (finishTime - startTime)));
        return arrayToSort;
    }

    public static int[] insertionSort(int[] array) {
        long startTime = System.nanoTime();
        int[] arrayToSort = Arrays.copyOf(array, array.length);
        for (int i = 1; i < arrayToSort.length; i++) {
            for (int j = i; j > 0 && arrayToSort[j - 1] > arrayToSort[j]; j--) {
                int tmp = arrayToSort[j - 1];
                arrayToSort[j - 1] = arrayToSort[j];
                arrayToSort[j] = tmp;
            }
        }
        long finishTime = System.nanoTime();
        System.out.println(String.format("Массив из %d элементов отсортирован методом вставок за %d наносекунд", arrayToSort.length, (finishTime - startTime)));
        return arrayToSort;
    }
}
