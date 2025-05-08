package lr10.task_5;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "C:\\Users\\linail\\IdeaProjects\\java-core_2024-2025\\src\\lr10\\task_1\\example3.xlsx";
    private static final String SHEET_NAME = "Товары";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean retry = true;

        while (retry) {
            try {
                File file = new File(FILE_PATH);
                if (!file.exists()) {
                    throw new IOException("Файл не найден: " + FILE_PATH);
                }
                if (!FILE_PATH.toLowerCase().endsWith(".xlsx")) {
                    throw new IOException("Неправильный формат файла. Ожидается .xlsx");
                }

                try (FileInputStream fis = new FileInputStream(file);
                     XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

                    XSSFSheet sheet = workbook.getSheet(SHEET_NAME);
                    if (sheet == null) {
                        throw new IOException("Лист с именем '" + SHEET_NAME + "' не найден.");
                    }

                    System.out.println("Данные из листа '" + SHEET_NAME + "':");
                    for (Row row : sheet) {
                        for (Cell cell : row) {
                            System.out.print(cell.toString() + "\t");
                        }
                        System.out.println();
                    }

                    retry = false;
                }

            } catch (IOException e) {
                System.err.println("Ошибка: " + e.getMessage());
                System.err.println("Подсказка: проверьте путь, формат файла и наличие листа '" + SHEET_NAME + "'.");
                System.out.print("Хотите попробовать снова? (да/нет): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (!answer.equals("да")) {
                    retry = false;
                }
            }
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }
}