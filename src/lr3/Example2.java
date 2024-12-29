package lr3;

import java.util.Scanner;

public class Example2 {
    // Напишите программу, в которой пользователю предлагается ввести название дня недели.
    // По введенному названию программа определяет порядковый номер дня в неделе.
    // Если пользователь вводит неправильное название дня, программа выводит сообщение о том, что такого дня нет.
    // Предложите версию программы на основе вложенных условных операторов и на основе оператора выбора switch.
    private static final String DAY_MESSAGE = "Порядковый номер дня: ";
    private static final String NO_SUCH_DAY_MESSAGE = "Такого дня нет.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Варианты определения порядкового номера дня недели:");
        System.out.println("1 - Вложенные условные операторы");
        System.out.println("2 - Оператор выбора switch");
        System.out.println("Выберите вариант:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                findDayOfWeekUsingNestedIf(askDayOfWeek(scanner));
                break;
            case 2:
                findDayOfWeekUsingSwitch(askDayOfWeek(scanner));
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте еще раз.");
                break;
        }

        scanner.close();
    }

    private static String askDayOfWeek(Scanner scanner) {
        System.out.println("Введите название дня недели:");
        return scanner.next().toLowerCase();
    }

    private static void findDayOfWeekUsingNestedIf(String dayName) {
        if (dayName.equals("понедельник")) {
            System.out.println(DAY_MESSAGE + "1");
        } else if (dayName.equals("вторник")) {
            System.out.println(DAY_MESSAGE + "2");
        } else if (dayName.equals("среда")) {
            System.out.println(DAY_MESSAGE + "3");
        } else if (dayName.equals("четверг")) {
            System.out.println(DAY_MESSAGE + "4");
        } else if (dayName.equals("пятница")) {
            System.out.println(DAY_MESSAGE + "5");
        } else if (dayName.equals("суббота")) {
            System.out.println(DAY_MESSAGE + "6");
        } else if (dayName.equals("воскресенье")) {
            System.out.println(DAY_MESSAGE + "7");
        } else {
            System.out.println(NO_SUCH_DAY_MESSAGE);
        }
    }

    private static void findDayOfWeekUsingSwitch(String dayName) {
        switch (dayName.toLowerCase()) {
            case "понедельник":
                System.out.println(DAY_MESSAGE + "1");
                break;
            case "вторник":
                System.out.println(DAY_MESSAGE + "2");
                break;
            case "среда":
                System.out.println(DAY_MESSAGE + "3");
                break;
            case "четверг":
                System.out.println(DAY_MESSAGE + "4");
                break;
            case "пятница":
                System.out.println(DAY_MESSAGE + "5");
                break;
            case "суббота":
                System.out.println(DAY_MESSAGE + "6");
                break;
            case "воскресенье":
                System.out.println(DAY_MESSAGE + "7");
                break;
            default:
                System.out.println(NO_SUCH_DAY_MESSAGE);
                break;
        }
    }
}
