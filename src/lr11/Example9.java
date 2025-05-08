package lr11;

import java.util.List;
import java.util.stream.Collectors;

public class Example9 {
    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "123", "World", "Java8", "Stream", "Тест", "пример123", "Чисто");

        System.out.println("Исходный список строк:");
        for (String s : strings) {
            System.out.println(s);
        }

        List<String> filtered = filterAlphabetic(strings);

        System.out.println("\nСтроки, содержащие только буквы:");
        for (String s : filtered) {
            System.out.println(s);
        }
    }

    public static List<String> filterAlphabetic(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-Я]+"))
                .collect(Collectors.toList());
    }
}