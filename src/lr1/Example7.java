package lr1;

import java.util.Scanner;

public class Example7 {
    // Напишите программу, в которой Пользователь вводит имя и возраст.
    // Программа отображает сообщение об имени и возрасте пользователя.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        System.out.println("Здравствуйте, " + name + ". Ваш возраст: " + age + " лет.");

        scanner.close();
    }
}
