package lr11;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = List.of(3, 7, 12, 18, 5, 24, 9, 1);

        System.out.println("Исходный список чисел:");
        for (Integer n : numbers) {
            System.out.println(n);
        }

        System.out.print("\nВведите значение, с которым сравнивать: ");
        int threshold = in.nextInt();

        List<Integer> filtered = filterGreaterThan(numbers, threshold);

        System.out.println("\nЧисла, большие " + threshold + ":");
        for (Integer n : filtered) {
            System.out.println(n);
        }
    }

    public static List<Integer> filterGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }
}