package lr10.task_4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final String URL = "https://www.e1.ru/horoscope/daily/";
    private static final String OUTPUT_FILE = "src/lr10/task_4/horoscope.txt";
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        Document doc = null;
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                System.out.println("Попытка подключения #" + attempt + " к " + URL);
                doc = Jsoup.connect(URL).get();
                break;
            } catch (IOException e) {
                System.err.println("Не удалось подключиться: " + e.getMessage());
                if (attempt == MAX_ATTEMPTS) {
                    System.err.println("Превышено число попыток. Выход.");
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
        }

        parseAndSaveHoroscope(doc);
    }

    private static void parseAndSaveHoroscope(Document doc) {
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            Elements section = doc.select(
                    "#app > div.global-wrapper > div.app-content > " +
                            "div > div.inner-columns-wrapper > div.central-right-wrapper > " +
                            "div.central-column-container > section"
            );

            List<Node> nodes = section.get(0).childNodes();
            for (int i = 2; i < 14; i++) {
                Element elm = (Element) nodes.get(i);
                String theme = elm.getElementsByClass("_4K6U+ _9dcVo").get(0).text();
                String date = elm.getElementsByClass("vpvdP _9TfK4").get(0).text();
                String text = elm.getElementsByClass("BDPZt KUbeq").text();

                String block = "Тема:  " + theme + "\n" +
                        "Дата:  " + date + "\n" +
                        "Текст: " + text + "\n\n";

                writer.write(block);
                System.out.print(block);
            }

            System.out.println("Данные записаны в файл: " + OUTPUT_FILE);
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}