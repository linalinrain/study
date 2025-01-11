package lr6;

public class Example8 {
    // Напишите программу со статическим методом, аргументом которому передается
    // целочисленный массив, а результатом возвращается среднее значение для элементов
    // массива (сумма значений элементов, деленная на количество элементов в массиве).
    public static class ClassExample8 {
        // Статический метод для вычисления среднего значения элементов массива
        public static double calculateAverageOfArrayElements(int[] array) {
            if (array == null || array.length == 0) {
                throw new IllegalArgumentException("Ошибка: массив не должен быть null или пустым.");
            }

            long sum = 0;

            for (int num : array) {
                sum = sum + num;
            }

            return (double) sum / array.length;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        // Вычисление среднего значения элементов массива
        double average = ClassExample8.calculateAverageOfArrayElements(numbers);
        System.out.println("Среднее значение массива: " + average);
    }
}