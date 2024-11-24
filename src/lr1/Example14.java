package lr1;

import java.util.Scanner;

public class Example14 {
    // Напишите программу, в которой пользователь вводит число, а программой
    // отображается последовательность из четырех чисел:
    // число, на единицу меньше введённого
    // введенное число и
    // число, на единицу больше введенного.
    // Четвертое число должно быть квадратом суммы первых трех чисел.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        int number = scanner.nextInt();

        int firstNumber = number - 1;
        int secondNumber = number;
        int thirdNumber = number + 1;
        int fourthNumber = (int) Math.pow((firstNumber + secondNumber + thirdNumber), 2);

        System.out.println(firstNumber + ", " + secondNumber + ", " + thirdNumber + ", " + fourthNumber);

        scanner.close();
    }
}
