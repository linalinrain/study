package lr1;

import java.util.Scanner;

public class Example13 {
    // Напишите программу для вычисления суммы двух чисел. Оба числа
    // вводятся пользователем. Для вычисления суммы используйте оператор +.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int firstNumber = scanner.nextInt();

        System.out.println("Введите второе число:");
        int secondNumber = scanner.nextInt();

        int sum = firstNumber + secondNumber;

        System.out.println("Сумма чисел: " + sum);

        scanner.close();
    }
}
