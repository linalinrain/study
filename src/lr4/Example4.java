package lr4;

public class Example4 {
    // Напишите программу, в которой создается двумерный массив,
    // который выводит прямоугольный треугольник
    public static void main(String[] args) {
        int size = 5; // Размер треугольника
        char[][] triangle = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = '*';
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}