package lr3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Example9 {
    // Напишите программу, в которой создается массив и заполняется случайными числами.
    // Массив отображается в консольном окне.
    // В этом массиве необходимо определить элемент с минимальным значением.
    // В частности, программа должна вывести значение элемента с минимальным значением и индекс этого элемента.
    // Если элементов с минимальным значением несколько, должны быть выведены индексы всех этих элементов.
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        int bound = 100;

        fillArrayWithRandomNumbers(array, bound);

        System.out.println("Массив:");
        printArray(array);
        System.out.println();

        int minNumber = Arrays.stream(array).min().getAsInt();

        int[] indexes = findIndexesOfValueInArray(array, minNumber);
        System.out.println("Индексы минимальных значений в массиве:");
        printArray(indexes);
        System.out.println();
    }

    private static void fillArrayWithRandomNumbers(int[] array, int bound) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound);
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int[] findIndexesOfValueInArray(int[] array, int value) {
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                indexes.add(i);
            }
        }

        return indexes.stream().mapToInt(i -> i).toArray();
    }
}
