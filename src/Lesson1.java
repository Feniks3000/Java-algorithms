import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
Задание 1.3
    Напишите программный код, в котором все данные хранятся только в
    переменных трех типов данных: Ссылочные, примитивные и своего класса
    содержащего: конструктор и метод отображения данных.
    Выведите написанные данные.

Задание 1.4
    Дополните предыдущий код сравнением ваших данных с другой
    переменной, данный код должен имитировать простейший поиск перебором.
    Оцените время выполнения алгоритма с помощью базового метода
    System.nanoTime().
 */
public class Lesson1 {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Как назовем нового человека? ");
        String name = in.nextLine();
        System.out.print("Какого возраста он будет? ");
        int age = in.nextInt();
        Man man = new Man("Иван", 34);
        System.out.println("Создан " + man.toString());

        int[] array = createRandomArray(30);
        System.out.println("Сгенерирован массив: " + Arrays.toString(array));

        boolean exists = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == man.getAge()) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("В массиве есть число равное возрасту " + man.getName());
        } else {
            System.out.println("В массиве нет числа равного возрасту " + man.getName());
        }
    }

    public static int[] createRandomArray(int count) {
        Random random = new Random();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
