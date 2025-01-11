package lr6;

import java.util.Arrays;

public class Example6 {
    // Напишите программу со статическим методом, которому аргументом передается
    // целочисленный массив и целое число. Результатом метод возвращает ссылку на новый
    // массив, который получается из исходного массива (переданного первым аргументом
    // методу), если в нем взять несколько начальных элементов. Количество элементов,
    // которые нужно взять из исходного массива, определяются вторым аргументом метода.
    // Если второй аргумент метода больше длины массива, переданного первым аргументом,
    // то методом создается копия исходного массива и возвращается ссылка на эту копию.
    public static class ClassExample6 {
        // Статический метод для получения части массива
        public static int[] getArrayPart(int[] array, int count) {
            if (array == null) {
                throw new IllegalArgumentException("Ошибка: массив не должен быть null.");
            }

            if (count < 0) {
                throw new IllegalArgumentException("Ошибка: количество элементов не может быть отрицательным.");
            }

            int[] newArray;

            if (count > array.length) {
                newArray = copyArray(array, array.length); // Создаем копию массива
            } else {
                newArray = copyArray(array, count); // Создаем часть массива
            }

            return newArray;
        }

        // Метод для копирования массива
        private static int[] copyArray(int[] array, int count) {
            int[] copy = new int[count];

            for (int i = 0; i < count; i++) {
                copy[i] = array[i];
            }
            return copy;
        }
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};

        // Пример с количеством меньше длины массива
        int[] resultArrayLess = ClassExample6.getArrayPart(originalArray, 3);
        System.out.println("Получение части массива (меньше длины). Результат: " + Arrays.toString(resultArrayLess));

        // Пример с количеством равным длине массива
        int[] resultArrayEqual = ClassExample6.getArrayPart(originalArray, 5);
        System.out.println("Получение части массива (равно длине). Результат: " + Arrays.toString(resultArrayEqual));

        // Пример с количеством больше длины массива
        int[] resultArrayMore = ClassExample6.getArrayPart(originalArray, 10);
        System.out.println("Получение полной копии массива (больше длины). Результат: " + Arrays.toString(resultArrayMore));
    }
}
