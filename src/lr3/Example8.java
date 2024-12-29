package lr3;

import java.util.Set;

public class Example8 {
    // Напишите программу, в которой создается символьный массив из 10 элементов.
    // Массив заполнить большими (прописными) буквами английского алфавита.
    // Буквы берутся подряд, но только согласные (то есть гласные буквы ’А' , 'Е' и 'I'
    // при присваивании значений элементам массива нужно пропустить).
    // Отобразите содержимое созданного массива в консольном окне.
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'u', 'o');

    public static void main(String[] args) {
        int size = 10;
        char[] array = new char[size];
        char startChar = 'a';

        fillArrayWithLetters(array, startChar);

        System.out.println("Содержимое массива:");
        printArray(array);
    }

    private static void fillArrayWithLetters(char[] array, char startChar) {
        int index = 0;
        int amountOfCharacters = 0;
        int arraySize = array.length;

        for (int i = 0; amountOfCharacters < arraySize; i++) {
            var character = (char) (startChar + i);

            if (!VOWELS.contains(character)) {
                array[index] = character;
                index += 1;
                amountOfCharacters += 1;
            }
        }
    }

    private static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
