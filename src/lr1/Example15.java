package lr1;

import java.util.Scanner;

public class Example15 {
    // Напишите программу, в которой Пользователь вводит два числа, а
    // программой вычисляется и отображается сумма и разность этих чисел.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int firstNumber = scanner.nextInt();

        System.out.println("Введите второе число:");
        int secondNumber = scanner.nextInt();

        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;

        System.out.println("Сумма: " + sum);
        System.out.println("Разность: " + difference);

        scanner.close();
    }
}
