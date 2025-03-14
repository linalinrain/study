package lr9.task_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Введите элементы массива:");
        readArray(scanner, array, 0);

        System.out.print("Вывод массива: ");
        printArray(array, 0);
        scanner.close();
    }

    // Рекурсивный метод для ввода элементов массива
    public static void readArray(Scanner scanner, int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        array[index] = scanner.nextInt();
        readArray(scanner, array, index + 1);
    }

    // Рекурсивный метод для вывода элементов массива
    public static void printArray(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        System.out.print(array[index] + " ");
        printArray(array, index + 1);
    }
}