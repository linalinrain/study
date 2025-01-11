package lr4;

import java.util.Random;

public class Example5 {
    // Напишите программу, в которой создается двумерный целочисленный массив.
    // Он заполняется случайными числами.
    // Затем в этом массиве строки и столбцы меняются местами:
    // первая строка становится первым столбцом,
    // вторая строка становиться вторым столбцом и так далее.
    public static void main(String[] args) {
        int rows = 5; // Количество строк
        int cols = 5; // Количество столбцов
        int[][] originalArray = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                originalArray[i][j] = random.nextInt(100);
            }
        }

        System.out.println("Исходный массив:");
        printArray(originalArray);

        System.out.println();

        int[][] changedArray = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                changedArray[j][i] = originalArray[i][j];
            }
        }

        System.out.println("Измененный массив:");
        printArray(changedArray);
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println();
        }
    }
}