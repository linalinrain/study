package lr6;

import java.util.Arrays;

public class Example9 {
    // Напишите программу со статическим методом, аргументом которому передается
    // одномерный символьный массив. В результате вызова метода элементы массива попарно
    // меняются местами: первый — с последним, второй — с предпоследним и так далее.
    public static class ClassExample9 {
        // Статический метод для попарной перестановки элементов символьного массива
        public static char[] swapCharArrayElements(char[] array) {
            if (array == null || array.length == 0) {
                throw new IllegalArgumentException("Ошибка: массив не должен быть null или пустым.");
            }

            int length = array.length;

            for (int i = 0; i < length / 2; i++) {
                int leftIndex = i;
                int rightIndex = (length - 1) - i;
                char leftCharElement = array[leftIndex];
                char rightCharElement = array[rightIndex];

                array[leftIndex] = rightCharElement;
                array[rightIndex] = leftCharElement;
            }

            return array;
        }
    }

    public static void main(String[] args) {
        char[] charArray = {'В', 'л', 'а', 'д', 'и', 'м', 'и', 'р', ' ', 'М', 'и', 'т', 'я', 'г', 'и', 'н'};

        // Попарная перестановка элементов массива
        char[] swappedArray = ClassExample9.swapCharArrayElements(charArray);
        System.out.println("Массив после перестановки: " + Arrays.toString(swappedArray));
    }
}
