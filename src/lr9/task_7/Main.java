package lr9.task_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 10000; // количество человек в кругу

        // Тест для ArrayList
        System.out.println("Тестирование с использованием ArrayList, n = " + n);
        long startTime = System.nanoTime();
        int survivorArrayList = simulateWithArrayList(n);
        long elapsedTimeArrayList = System.nanoTime() - startTime;
        System.out.println("Оставшийся человек (ArrayList): " + survivorArrayList);
        System.out.printf("Время работы (ArrayList): %.3f ms\n\n", elapsedTimeArrayList / 1_000_000.0);

        // Тест для LinkedList
        System.out.println("Тестирование с использованием LinkedList, n = " + n);
        startTime = System.nanoTime();
        int survivorLinkedList = simulateWithLinkedList(n);
        long elapsedTimeLinkedList = System.nanoTime() - startTime;
        System.out.println("Оставшийся человек (LinkedList): " + survivorLinkedList);
        System.out.printf("Время работы (LinkedList): %.3f ms\n", elapsedTimeLinkedList / 1_000_000.0);
    }

    // Моделирование процесса с использованием ArrayList
    public static int simulateWithArrayList(int n) {
        List<Integer> persons = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            persons.add(i);
        }
        int index = 0;
        while (persons.size() > 1) {
            // Определяем индекс для удаления: каждый второй человек (счёт ведется по кругу)
            index = (index + 1) % persons.size();
            persons.remove(index);
        }
        return persons.get(0);
    }

    // Моделирование процесса с использованием LinkedList
    public static int simulateWithLinkedList(int n) {
        List<Integer> persons = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            persons.add(i);
        }
        int index = 0;
        while (persons.size() > 1) {
            index = (index + 1) % persons.size();
            persons.remove(index);
        }
        return persons.get(0);
    }
}