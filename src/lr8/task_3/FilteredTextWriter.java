package lr8.task_3;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilteredTextWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос пути к исходному файлу
        System.out.print("Введите путь к исходному файлу: ");
        String inputFile = scanner.nextLine();

        // Определяем директорию исходного файла
        File input = new File(inputFile);
        String parentDir = input.getParent(); // Получаем папку, где лежит исходный файл

        // Формируем путь для результирующего файла
        String outputFile = parentDir + File.separator + "output.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;

        // Список согласных букв русского алфавита
        List<Character> consonants = Arrays.asList(
                'б', 'в', 'г', 'д', 'ж', 'з', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ'
        );

        try {
            // Открываем поток для чтения из исходного файла (UTF-8)
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(inputFile), "UTF-8"));

            // Открываем поток для записи в результирующий файл (UTF-8)
            bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(outputFile), "UTF-8"));

            System.out.println("Результирующий файл будет создан по пути: " + outputFile);

            String line;
            int lineNumber = 0;

            // Построчное чтение из исходного файла
            while ((line = br.readLine()) != null) {
                lineNumber++;

                // Разделяем строку на слова, используя split() по пробелу и знакам препинания
                String[] words = line.split("[\\s,.;:!?()\"—]+");

                StringBuilder filteredWords = new StringBuilder();
                int wordCount = 0;

                // Проверяем каждое слово
                for (String word : words) {
                    if (!word.isEmpty() && consonants.contains(word.charAt(0))) {
                        filteredWords.append(word).append(" ");
                        wordCount++;
                    }
                }

                // Если найдены подходящие слова, записываем строку в файл
                if (wordCount > 0) {
                    bw.write("Строка " + lineNumber + " (" + wordCount + " слов): " + filteredWords.toString().trim());
                    bw.newLine();
                }
            }

            System.out.println("Обработка завершена! Данные записаны в " + outputFile);
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлами: " + e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файлов: " + e);
            }
        }
    }
}