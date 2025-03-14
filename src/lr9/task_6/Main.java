package lr9.task_6;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = createMap();
        printEntriesWithKeyGreaterThanFive(map);
        printAllValuesIfContainsKeyZero(map);
        multiplyKeysWhereValueLengthGreaterThanFive(map);
    }

    // Метод для заполнения HashMap 10 объектами <Integer, String>
    public static HashMap<Integer, String> createMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "zero");      // length = 4
        map.put(1, "one");       // length = 3
        map.put(2, "two");       // length = 3
        map.put(3, "three");     // length = 5
        map.put(4, "four");      // length = 4
        map.put(5, "five");      // length = 4
        map.put(6, "sixteen");   // length = 7 (>5)
        map.put(7, "seventy");   // length = 7 (>5)
        map.put(8, "eighty");    // length = 6 (>5)
        map.put(9, "ninety");    // length = 6 (>5)
        return map;
    }

    // 1. Метод для вывода строк, у которых ключ > 5.
    public static void printEntriesWithKeyGreaterThanFive(HashMap<Integer, String> map) {
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println("Ключ " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // 2. Метод для вывода всех строк через запятую, если в мапе присутствует ключ 0.
    public static void printAllValuesIfContainsKeyZero(HashMap<Integer, String> map) {
        if (map.containsKey(0)) {
            StringJoiner joiner = new StringJoiner(", ");
            for (String value : map.values()) {
                joiner.add(value);
            }
            System.out.println("\nПоскольку ключ 0 присутствует, выводим все строки через запятую:");
            System.out.println(joiner);
        }
    }

    // 3. Упрощенный метод для перемножения ключей, где длина соответствующей строки > 5.
    public static void multiplyKeysWhereValueLengthGreaterThanFive(HashMap<Integer, String> map) {
        // Сначала собираем все ключи, у которых длина строки больше 5.
        ArrayList<Integer> filteredKeys = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                filteredKeys.add(entry.getKey());
            }
        }

        // Если таких ключей нет, выводим сообщение.
        if (filteredKeys.isEmpty()) {
            System.out.println("\nНет строк, длина которых больше 5 символов.");
            return;
        }

        // Перемножаем ключи из списка.
        long multiplicationResult = 1;
        for (int key : filteredKeys) {
            multiplicationResult *= key;
        }
        System.out.println("\nПроизведение ключей, у которых длина строки > 5: " + multiplicationResult);
    }
}