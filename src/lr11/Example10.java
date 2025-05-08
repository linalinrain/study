package lr11;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = List.of(5, 12, 3, 25, 8, 19, 2, 30);

        System.out.println("Исходный список чисел:");
        for (Integer n : numbers) {
            System.out.println(n);
        }

        System.out.print("\nВведите значение, с которым сравнивать: ");
        int threshold = in.nextInt();

        List<Integer> filtered = filterLessThan(numbers, threshold);

        System.out.println("\nЧисла, меньшие " + threshold + ":");
        for (Integer n : filtered) {
            System.out.println(n);
        }
    }

    public static List<Integer> filterLessThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }
}