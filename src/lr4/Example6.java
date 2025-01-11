package lr4;

import java.util.Random;

public class Example6 {
    // Напишите программу, в которой создается и инициализируется двумерный числовой массив.
    // Затем из этого массива удаляется строка и столбец
    // (создается новый массив, в котором по сравнению с исходным удалена одна строка и один столбец).
    // Индекс удаляемой строки и индекс удаляемого столбца определяется с помощью генератора случайных чисел.
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

        int rowIndexToRemove = random.nextInt(rows);
        int colIndexToRemove = random.nextInt(cols);

        System.out.println();

        System.out.println("Будут удалена строка с индексом " + rowIndexToRemove);
        System.out.println("Будет удален столбец с индексом " + colIndexToRemove);

        // Создание нового массива с удалённой строкой и столбцом
        int[][] reducedArray = new int[rows - 1][cols - 1];

        for (int i = 0, newI = 0; i < rows; i++) {
            if (i == rowIndexToRemove) continue;
            for (int j = 0, newJ = 0; j < cols; j++) {
                if (j == colIndexToRemove) continue;
                reducedArray[newI][newJ] = originalArray[i][j];
                newJ++;
            }
            newI++;
        }

        System.out.println();

        System.out.println("Массив после удаления строки и столбца:");
        printArray(reducedArray);
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