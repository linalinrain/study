package lr3;

public class Example7 {
    // Напишите программу, в которой создается одномерный символьный массив из 10 элементов.
    // Массив заполняется буквами «через одну», начиная с буквы 'а'.
    // То есть массив заполняется буквами 'а' , 'с' , 'е' , 'д' и так далее.
    // Отобразите массив в консольном окне в прямом и обратном порядке.
    // Размер массива задается переменной.
    public static void main(String[] args) {
        int size = 10;
        char[] array = new char[size];
        char startChar = 'а';

        fillArrayWithLetters(array, startChar);

        System.out.println("Массив в прямом порядке:");
        printArray(array);

        System.out.println();

        System.out.println("Массив в обратном порядке:");
        printArrayInReversedOrder(array);
    }

    private static void fillArrayWithLetters(char[] array, char startChar) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (startChar + i);
        }
    }

    private static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void printArrayInReversedOrder(char[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
