package lr3;

import java.util.Scanner;

public class Example6 {
    // Напишите программу, в которой создается одномерный числовой
    // массив и заполняется числами, которые при делении на 5 дают в остатке 2
    // (числа 2, 7,12,17 и так далее). Размер массива вводится пользователем.
    // Предусмотреть обработку ошибки, связанной с вводом некорректного
    // значения.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int size = getUserInputWithValidation(scanner);

        int[] array = new int[size];

        fillArray(array);
        printArray(array);

        scanner.close();
    }

    private static int getUserInputWithValidation(Scanner scanner) {
        int size;

        while (true) {
            try {
                size = scanner.nextInt();
                if (size > 0) {
                    return size;
                } else {
                    System.out.println("Размер массива должен быть больше 0. Введите корректное значение:");
                }
            } catch (Exception e) {
                System.out.println("Введенное значение некорректно. Введите корректное значение:");
                scanner.next();
            }
        }
    }

    private static void fillArray(int[] array) {
        int index = 0;
        int arraySize = array.length;
        int amountOfNumbers = 0;

        for (int i = 0; amountOfNumbers < arraySize; i++) {
            if (i % 5 == 2) {
                array[index] = i;
                index += 1;
                amountOfNumbers += 1;
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
