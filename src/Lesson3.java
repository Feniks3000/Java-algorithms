import lesson3.DoublyLinkedList;
import lesson3.Node;
import lesson3.SinglyLinkedList;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson3 {
/*
Задание 3.1
    На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
    Оцените время выполнения преобразования.
Задание 3.2
    На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
    Оценить выполненные методы с помощью базового класса System.nanoTime().
Задание 3.3
    Реализуйте простой односвязный список и его базовые методы.
Задание 3.4
    На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
    Реализуйте список заполненный объектами из вашего класса из задания 1.3
Задание 3.5
    Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
    Оцените время выполнения операций с помощью базового метода System.nanoTime()
*/

    public static void main(String[] args) {
        int[] array = Helper.createRandomArray(400, 100);
        System.out.println("=============Задание 1 - создание коллекции и списка из массива==========================");
        testCreateCollection(array);
        List<Integer> list = testCreateList(array);
        System.out.println("\n=============Задание 2 - тестирование методов списка==========================");
        testListMethods(list);
        System.out.println("\n=============Задание 3 - создание своего односвязного списка==========================");
        testCreateSinglyLinkedList();
        System.out.println("\n=============Задание 4 - создание своего двусвязного списка==========================");
        DoublyLinkedList doublyLinkedList = testCreateDoublyLinkedList(array);
        testDoublyLinkedListMethods();
        System.out.println("\n=============Задание 5 - тестирование итератора по своему двусвязному списку==========================");
        testIteratorDoublyLinkedList(doublyLinkedList);
        System.out.println("\n=============Задание 6 - создание списка LinkedList и тестирование его методов==========================");
        LinkedList<Integer> linkedList = testCreateLinkedList(array);
        testLinkedListMethods(linkedList);
    }

    private static void testCreateCollection(int[] array) {
        long startTime = System.nanoTime();
        // Т.к. исходный массив был примитивного типа, то потребовалась магия, учитывающая кастование int в Integer.
        // Массив преобразовывался в List, а затем сохранялся в коллекцию.
        Collection<Integer> collection = Arrays.stream(array).boxed().collect(Collectors.toList());
        long finishTime = System.nanoTime();
        System.out.printf("Коллекция из %d элементов сформирована из массива int[] за %d наносекунд\n", collection.size(), (finishTime - startTime));
    }

    private static List<Integer> testCreateList(int[] array) {
        long startTime = System.nanoTime();
        // Т.к. исходный массив был примитивного типа, то потребовалась магия, учитывающая кастование int в Integer.
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        long finishTime = System.nanoTime();
        System.out.printf("Список из %d элементов сформирован из массива int[] за %d наносекунд\n", list.size(), (finishTime - startTime));
        return list;
    }

    private static LinkedList<Integer> testCreateLinkedList(int[] array) {
        long startTime = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int value : array) {
            linkedList.add(value);
        }
        long finishTime = System.nanoTime();
        System.out.printf("Двусвязный список из %d элементов сформирован из массива int[] за %d наносекунд\n", linkedList.size(), (finishTime - startTime));
        return linkedList;
    }

    private static void testListMethods(List<Integer> list) {
        long startTime = System.nanoTime();
        list.add(999);
        long finishTime = System.nanoTime();
        System.out.printf("Добавление элемента в конец списка из %d элементов выполнено за %d наносекунд\n", list.size(), (finishTime - startTime));
        startTime = System.nanoTime();
        list.remove(list.size() - 1);
        finishTime = System.nanoTime();
        System.out.printf("Удаление последнего элемента списка из %d элементов выполнено за %d наносекунд\n", list.size(), (finishTime - startTime));
        startTime = System.nanoTime();
        Integer element100 = list.get(100);
        finishTime = System.nanoTime();
        System.out.printf("Получение элемента на 100 позиции из списка из %d элементов выполнено за %d наносекунд\n", list.size(), (finishTime - startTime));
    }

    private static void testLinkedListMethods(List<Integer> list) {
        long startTime = System.nanoTime();
        list.add(999);
        long finishTime = System.nanoTime();
        System.out.printf("Добавление элемента в конец двусвязного списка из %d элементов выполнено за %d наносекунд\n", list.size(), (finishTime - startTime));
        startTime = System.nanoTime();
        list.remove(list.size() - 1);
        finishTime = System.nanoTime();
        System.out.printf("Удаление последнего элемента двусвязного списка из %d элементов выполнено за %d наносекунд\n", list.size(), (finishTime - startTime));
        startTime = System.nanoTime();
        Integer element100 = list.get(100);
        finishTime = System.nanoTime();
        System.out.printf("Получение элемента на 100 позиции из двусвязного списка из %d элементов выполнено за %d наносекунд\n", list.size(), (finishTime - startTime));
    }

    private static void testCreateSinglyLinkedList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println("Добавляем элемент (1) в конец пустого списка, задавая тем самым корневой элемент");
        singlyLinkedList.addToEnd(1);
        singlyLinkedList.printList();
        System.out.println("Добавляем еще один элемент (2) в конец списка. Видим, что первый элемент начал ссылаться на второй");
        singlyLinkedList.addToEnd(2);
        singlyLinkedList.printList();
        System.out.println("Добавляем элемент (3) на позицию второго элемента списка, сдвинув (2) дальше");
        singlyLinkedList.add(1, 3);
        singlyLinkedList.printList();
        System.out.println("Удаляем корневой элемент (1) из списка, сдвигая (3) в начало");
        singlyLinkedList.remove(0);
        singlyLinkedList.printList();
        System.out.println("Удаляем второй элемент (2) из списка, оставляя (3) в качестве единственного элемента в списке");
        singlyLinkedList.remove(1);
        singlyLinkedList.printList();
    }

    private static DoublyLinkedList testCreateDoublyLinkedList(int[] array) {
        long startTime = System.nanoTime();
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        for (int item : array) {
            doublyLinkedList.addToEnd(item);
        }
        long finishTime = System.nanoTime();
        System.out.printf("Свой двусвязный список из %d элементов сформирован из массива int[] за %d наносекунд\n", array.length, (finishTime - startTime));
        doublyLinkedList.sortPrintList();
        return doublyLinkedList;
    }

    private static void testDoublyLinkedListMethods() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        System.out.println("Добавляем элемент (1) в конец пустого списка, задавая тем самым корневой элемент");
        doublyLinkedList.addToEnd(1);
        doublyLinkedList.printList();
        System.out.println("Добавляем еще один элемент (2) в конец списка. Видим, что первый элемент начал ссылаться на второй, в второй - на первый");
        doublyLinkedList.addToEnd(2);
        doublyLinkedList.printList();
        System.out.println("Добавляем элемент (3) на позицию второго элемента списка, сдвинув (2) дальше");
        doublyLinkedList.add(1, 3);
        doublyLinkedList.printList();
        System.out.println("Удаляем корневой элемент (1) из списка, сдвигая (3) в начало");
        doublyLinkedList.remove(0);
        doublyLinkedList.printList();
        System.out.println("Удаляем второй элемент (2) из списка, оставляя (3) в качестве единственного элемента в списке");
        doublyLinkedList.remove(1);
        doublyLinkedList.printList();
        System.out.println("Добавляем элемент (4) в начало списка, сдвигая 3 в конец");
        doublyLinkedList.add(0, 4);
        doublyLinkedList.printList();
    }

    private static void testIteratorDoublyLinkedList(DoublyLinkedList doublyLinkedList) {
        System.out.println("Пример итерации по своему двусвязному списку от начального элемента");
        Node node = doublyLinkedList.getRoot();
        while (node.hasNext()) {
            System.out.println(node);
            node = node.getNext();
        }
        System.out.println(node);
        System.out.println("\nПример итерации по своему двусвязному списку от конечного элемента");
        node = doublyLinkedList.getTermination();
        while (node.hasPrevious()) {
            System.out.println(node);
            node = node.getPrevious();
        }
        System.out.println(node);
    }
}
