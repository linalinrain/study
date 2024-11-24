package lr1;

import java.util.Scanner;

public class Example6 {
    // Напишите программу, в которой Пользователь вводит сначала фамилию,
    // затем имя, затем отчество. После ввода программа выводит сообщение
    // «Hello <фамилия, имя, отчество>».
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите отчество: ");
        String patronymic = scanner.nextLine();

        System.out.println("Hello <" + surname + "," + name + "," + patronymic + ">");

        scanner.close();
    }
}
