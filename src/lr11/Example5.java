package lr11;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = List.of("котёнок", "собака", "коты", "песик", "кот", "тигр", "котяра");

        System.out.println("Исходный список строк:");
        for (String s : strings) {
            System.out.println(s);
        }

        System.out.print("\nВведите подстроку для поиска: ");
        String substring = in.nextLine();

        List<String> filtered = filterBySubstring(strings, substring);

        System.out.println("\nСтроки, содержащие подстроку \"" + substring + "\":");
        for (String s : filtered) {
            System.out.println(s);
        }
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}