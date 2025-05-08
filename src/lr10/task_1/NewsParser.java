package lr10.task_1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class NewsParser {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.e1.ru/horoscope/daily/").get();
            Elements newsParent = doc
                    .select("#app > div.global-wrapper > div.app-content > " +
                            "div > div.inner-columns-wrapper > div.central-right-wrapper > " +
                            "div.central-column-container > section");
            for (int i = 2; i < 14; i++) {
                List<Node> nodes = newsParent.get(0).childNodes();
                System.out.println("Тема: " +
                        ((Element) nodes.get(i))
                                .getElementsByClass("_4K6U+ _9dcVo")
                                .get(0).childNodes().get(0));
                System.out.println("Дата: " +
                        ((Element) nodes.get(i))
                                .getElementsByClass("vpvdP _9TfK4")
                                .get(0).childNodes().get(0));
                System.out.println("Текст: " +
                        ((Element) nodes.get(i))
                                .getElementsByClass("BDPZt KUbeq").text() +
                        "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}