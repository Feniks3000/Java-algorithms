import java.util.Arrays;

public class Lesson2 {
/*
Задание 2.1
    На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
    Выполните обращение к массиву и базовые операции класса Arrays.
    Оценить выполненные методы с помощью базового класса System.nanoTime().

Задание 2.2
    На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
    Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.

Задание 2.3
    Создайте массив размером 400 элементов.
    Выполните сортировку с помощью метода sort().
    Оцените сортировку с помощью базового класса System.nanoTime().

Задание 2.4
    На основе существующего массива  данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
    Оцените сортировку с помощью базового класса System.nanoTime().
    Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.

Задание 2.5
    На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
    Оцените сортировку с помощью базового класса System.nanoTime().
    Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.

Задание 2.6
    На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
    Оцените сортировку с помощью базового класса System.nanoTime().
    Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
 */

    public static void main(String[] args) {
        int[] array = Helper.createRandomArray(400, 100);
        System.out.println("=======================================");
        testArraysMethods(array, 53);       // Задание 1
        System.out.println("=======================================");
        testSearchAlgorithms(array, 53);    // Задание 2
        System.out.println("=======================================");
        testSortAlgorithms(array);
    }

    private static void testArraysMethods(int[] array, int keyForSearch) {
        System.out.printf("Строка с массивом Arrays.toString(): %s\n", Arrays.toString(array));

        long startTime = System.nanoTime();
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        long finishTime = System.nanoTime();
        System.out.printf("Создана копия массива из %d элементов за %d наносекунд\n", array.length, (finishTime - startTime));

        startTime = System.nanoTime();
        Arrays.sort(arrayCopy);
        finishTime = System.nanoTime();
        System.out.printf("Массив из %d элементов отсортирован за %d наносекунд\n", array.length, (finishTime - startTime));

        startTime = System.nanoTime();
        int searchedPosition = Arrays.binarySearch(arrayCopy, keyForSearch);
        finishTime = System.nanoTime();
        System.out.printf("Значение %d найдено бинарным поиском в отсортированном массиве на %d позиции за %d наносекунд\n",
                keyForSearch, searchedPosition, (finishTime - startTime));

        startTime = System.nanoTime();
        Arrays.fill(arrayCopy, 99);
        finishTime = System.nanoTime();
        System.out.printf("Копия массива из %d элементов заполнена числом 99 за %d наносекунд\n", array.length, (finishTime - startTime));

        startTime = System.nanoTime();
        boolean equalsArray = Arrays.equals(array, arrayCopy);
        finishTime = System.nanoTime();
        System.out.printf("Сравнение оригинального массива и его обработанной копии прошло за %d наносекунд. Массивы идентичны - %b\n", (finishTime - startTime), equalsArray);
    }

    private static void testSearchAlgorithms(int[] array, int keyForSearch) {
        int searchedPosition = -1;
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == keyForSearch) {
                searchedPosition = i;
                break;
            }
        }
        long finishTime = System.nanoTime();
        if (searchedPosition == -1) {
            System.out.printf("Значение %d в массиве не найдено. Время поиска - %d наносекунд\n", keyForSearch, (finishTime - startTime));
        } else {
            System.out.printf("Значение %d найдено на %d позиции в массиве. Время поиска - %d наносекунд\n", keyForSearch, searchedPosition, (finishTime - startTime));
        }

        int[] arrayCopy = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        Arrays.sort(arrayCopy);
        searchedPosition = Arrays.binarySearch(arrayCopy, keyForSearch);
        finishTime = System.nanoTime();
        System.out.printf("Для бинарного поиска массив был отсортирован. Значение %d найдено бинарным поиском на %d позиции массива за %d наносекунд\n",
                keyForSearch, searchedPosition, (finishTime - startTime));
    }

    private static void testSortAlgorithms(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();
        Arrays.sort(arrayCopy);                 // Задание 3
        long finishTime = System.nanoTime();
        System.out.printf("Массив из %d элементов отсортирован Array.sort() (быстрая сортировка) за %d наносекунд\n", arrayCopy.length, (finishTime - startTime));
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayCopy));

        arrayCopy = Helper.bubbleSort(array);   // Задание 4
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayCopy));

        arrayCopy = Helper.selectionSort(array);// Задание 5
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayCopy));

        arrayCopy = Helper.insertionSort(array);// Задание 6
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayCopy));



    }
}
