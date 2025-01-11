package lr6;

public class Example3 {
    // Напишите программу с классом, в котором есть статические методы,
    // которым можно передавать произвольное количество целочисленных аргументов (или целочисленный массив).
    // Методы, на основании переданных аргументов или массива,
    // позволяют вычислить: наибольшее значение из набора чисел.
    public static class ClassExample3 {
        // Статический метод для вычисления наибольшего значения из произвольного количества аргументов или массива
        public static int calculateMaxValueFromSet(int... numbers) {
            int max = Integer.MIN_VALUE;
            for (int number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        // Нахождение максимального значения среди произвольных аргументов
        int maxFromArguments = ClassExample3.calculateMaxValueFromSet(0, 3, 9, 1, 2, 0, 1, 9, 0);
        System.out.println("Максимальное значение (аргументы) = " + maxFromArguments);

        // Нахождение максимального значения в массиве
        int[] numbersArray = {1, 9, 0, 3, 2, 0, 9, 1, 0};
        int maxFromArray = ClassExample3.calculateMaxValueFromSet(numbersArray);
        System.out.println("Максимальное значение (массив) = " + maxFromArray);
    }
}