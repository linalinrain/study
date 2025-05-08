package lr11;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 33, 40, 45);

        System.out.println("Исходный список чисел:");
        for (Integer n : numbers) {
            System.out.println(n);
        }

        System.out.print("\nВведите число, на которое должны делиться элементы: ");
        int divisor = in.nextInt();

        List<Integer> filtered = filterDivisible(numbers, divisor);

        System.out.println("\nЧисла, делящиеся на " + divisor + ":");
        for (Integer n : filtered) {
            System.out.println(n);
        }
    }

    public static List<Integer> filterDivisible(List<Integer> list, int divisor) {
        return list.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }
}