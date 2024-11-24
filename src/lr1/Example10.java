package lr1;

import java.time.Year;
import java.util.Scanner;

public class Example10 {
    // Напишите программу, в которой по году рождения определяется возраст пользователя.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваш год рождения:");
        int birthYear = scanner.nextInt();

        Year currentYear = Year.now();
        int currentYearInt = currentYear.getValue();

        int ageIfBirthdayHappened = currentYearInt - birthYear;
        int ageIfBirthdayNotHappened = ageIfBirthdayHappened - 1;

        System.out.println("Ваш возраст если ваш День Рождения уже прошел: " + ageIfBirthdayHappened + " лет.");
        System.out.println("Ваш возраст если ваш День Рождения еще не прошел: " + ageIfBirthdayNotHappened + " лет.");

        scanner.close();
    }
}
