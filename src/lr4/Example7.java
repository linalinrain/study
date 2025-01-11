package lr4;

public class Example7 {
    // Напишите программу, в которой создается двумерный
    // числовой массив и этот массив заполняется «змейкой»:
    // сначала первая строка (слева направо), затем последний
    // столбец (сверху вниз), вторая строка (справа налево) и так далее.
    public static void main(String[] args) {
        int rows = 6; // Количество строк
        int cols = 6; // Количество столбцов
        int[][] snakeArray = new int[rows][cols];

        int num = 1; // Начальное значение для заполнения массива

        for (int i = 0; i < rows; i++) {
            boolean isRowEven = (i % 2 == 0); // Проверка, чётная ли строка

            if (isRowEven) {
                // Если строка чётная, заполняем слева направо
                for (int j = 0; j < cols; j++) {
                    snakeArray[i][j] = num++;
                }
            } else {
                // Если строка нечётная, заполняем справа налево
                for (int j = cols - 1; j >= 0; j--) {
                    snakeArray[i][j] = num++;
                }
            }
        }

        printArray(snakeArray);
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
