package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example8 {
    // Напишите программу «Шифр Цезаря», которая зашифровывает введенный текст.
    // Используйте кодовую таблицу символов.
    // При запуске программы в консоль необходимо вывести сообщение: «Введите текст для шифрования».
    // После ввода текста появляется сообщение: «Введите ключ».
    // Затем вывести преобразованную строку с сообщением «Текст после преобразования: ».
    // Далее необходимо задать вопрос пользователю: «Выполнить обратное преобразование? (y/n)».
    // Если пользователь вводит «y» — выполнить обратное преобразование.
    // Если пользователь вводит «n» — программа выводит сообщение «До свидания!».
    // Если ввод некорректный — вывести сообщение: «Введите корректный ответ».
    // Описание Шифра Цезаря:
    // Шифр Цезаря (лат. Notae Caesarianae), также известный как шифр сдвига или код Цезаря, —
    // разновидность шифра подстановки, в котором каждый символ в открытом тексте заменяется
    // символом, находящимся на некотором постоянном числе позиций левее или правее него в алфавите.
    // Например, в шифре со сдвигом вправо на 3, A была бы заменена на Г, Б стала бы Д, и так далее.
    // Шифр был назван в честь римского полководца Гая Юлия Цезаря, использовавшего его для
    // секретной переписки со своими военачальниками.
    // Источник: https://ru.wikipedia.org/wiki/Шифр_Цезаря
    private static final int CYRILLIC_ALPHABET_LENGTH = 32;
    private static final int LATIN_ALPHABET_LENGTH = 26;
    private static final int DIGIT_ALPHABET_LENGTH = 10;
    private static final char UPPER_CYRILLIC_BASE = 'А';
    private static final char LOWER_CYRILLIC_BASE = 'а';
    private static final char UPPER_LATIN_BASE = 'A';
    private static final char LOWER_LATIN_BASE = 'a';
    private static final char DIGIT_BASE = '0';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = getTextForEncryption(scanner);
        int key = getKey(scanner);

        String encryptedText = caesarCipher(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        boolean shouldDecrypt = shouldPerformDecryption(scanner);

        if (shouldDecrypt) {
            String decryptedText = caesarCipher(encryptedText, -key);
            System.out.println("Текст после обратного преобразования: " + decryptedText);
        } else {
            System.out.println("До свидания!");
        }

        scanner.close();
    }

    private static String getTextForEncryption(Scanner scanner) {
        System.out.println("Введите текст для шифрования:");
        return scanner.nextLine();
    }

    private static int getKey(Scanner scanner) {
        int key = 0;
        boolean validKey = false;

        while (!validKey) {
            System.out.println("Введите ключ (целое число):");
            try {
                key = scanner.nextInt();
                validKey = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: ключ должен быть целым числом. Попробуйте снова.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return key;
    }

    private static String caesarCipher(String text, int key) {
        StringBuilder result = new StringBuilder();
        char[] characters = text.toCharArray();

        for (char character : characters) {
            result.append(shiftCharacter(character, key));
        }
        return result.toString();
    }

    private static char shiftCharacter(char character, int key) {
        // В методе шифруются только Кириллица, Латиница и Цифры
        // Остальные символы остаются без изменений
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(character);
        boolean isCyrillic = unicodeBlock == Character.UnicodeBlock.CYRILLIC && Character.isLetter(character);
        boolean isLatinLetter = unicodeBlock == Character.UnicodeBlock.BASIC_LATIN && Character.isLetter(character);
        boolean isDigit = Character.isDigit(character);

        if (isCyrillic) {
            return shiftChar(character, key, UPPER_CYRILLIC_BASE, LOWER_CYRILLIC_BASE, CYRILLIC_ALPHABET_LENGTH);
        } else if (isLatinLetter) {
            return shiftChar(character, key, UPPER_LATIN_BASE, LOWER_LATIN_BASE, LATIN_ALPHABET_LENGTH);
        } else if (isDigit) {
            return shiftChar(character, key, DIGIT_BASE, DIGIT_BASE, DIGIT_ALPHABET_LENGTH);
        } else {
            return character;
        }
    }

    private static char shiftChar(char character, int key, char upperBase, char lowerBase, int alphabetLength) {
        // Нормализуем ключ чтобы он не выходил за пределы длины алфавита
        key = key % alphabetLength;
        boolean isUpperCase = Character.isUpperCase(character);
        int baseCode = isUpperCase ? (int) upperBase : (int) lowerBase;
        int characterCode = (int) character;
        int shiftedPosition = (characterCode - baseCode + key + alphabetLength) % alphabetLength;
        char shiftedCharacter = (char) (baseCode + shiftedPosition);
        return shiftedCharacter;
    }

    private static boolean shouldPerformDecryption(Scanner scanner) {
        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Ошибка: введите 'y' для подтверждения или 'n' для отказа. Попробуйте снова.");
            }
        }
    }
}