package lr10.task_2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final String FILE_PATH = "src/lr10/task_2/example01.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Document doc = loadOrCreateDocument();

            while (true) {
                System.out.println("\nВыберите действие:");
                System.out.println("1. Добавить новый урок");
                System.out.println("2. Найти урок по преподавателю");
                System.out.println("3. Найти урок по аудитории");
                System.out.println("4. Удалить урок по названию");
                System.out.println("5. Выйти");
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addNewLesson(doc, scanner);
                        break;
                    case 2:
                        searchByTeacher(doc, scanner);
                        break;
                    case 3:
                        searchByRoom(doc, scanner);
                        break;
                    case 4:
                        deleteLessonByName(doc, scanner);
                        break;
                    case 5:
                        saveDocument(doc);
                        System.out.println("Выход из программы.");
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document loadOrCreateDocument() throws Exception {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return dBuilder.parse(file);
        }
        // если файла нет — создаём новый
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element root = doc.createElement("schedule");
        doc.appendChild(root);
        return doc;
    }

    private static void saveDocument(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_PATH)));
        System.out.println("XML-файл успешно обновлен!");
    }

    private static void addNewLesson(Document doc, Scanner scanner) {
        System.out.print("Введите название предмета: ");
        String name = scanner.nextLine();
        System.out.print("Введите имя преподавателя: ");
        String teacher = scanner.nextLine();
        System.out.print("Введите номер аудитории: ");
        String room = scanner.nextLine();
        System.out.print("Введите время занятия: ");
        String time = scanner.nextLine();

        Element lesson = doc.createElement("lesson");

        Element nameEl = doc.createElement("name");
        nameEl.appendChild(doc.createTextNode(name));
        lesson.appendChild(nameEl);

        Element teacherEl = doc.createElement("teacher");
        teacherEl.appendChild(doc.createTextNode(teacher));
        lesson.appendChild(teacherEl);

        Element roomEl = doc.createElement("room");
        roomEl.appendChild(doc.createTextNode(room));
        lesson.appendChild(roomEl);

        Element timeEl = doc.createElement("time");
        timeEl.appendChild(doc.createTextNode(time));
        lesson.appendChild(timeEl);

        doc.getDocumentElement().appendChild(lesson);
        System.out.println("Урок успешно добавлен!");
    }

    private static void searchByTeacher(Document doc, Scanner scanner) {
        System.out.print("Введите имя преподавателя для поиска: ");
        String teacher = scanner.nextLine();

        List<Element> found = nodeListToStream(doc.getElementsByTagName("lesson"))
                .filter(el -> teacher.equalsIgnoreCase(el.getElementsByTagName("teacher").item(0).getTextContent()))
                .collect(Collectors.toList());

        if (found.isEmpty()) {
            System.out.println("Уроки данного преподавателя не найдены.");
        } else {
            System.out.println("Найденные уроки:");
            found.forEach(Main::printLessonInfo);
        }
    }

    private static void searchByRoom(Document doc, Scanner scanner) {
        System.out.print("Введите номер аудитории для поиска: ");
        String room = scanner.nextLine();

        List<Element> found = nodeListToStream(doc.getElementsByTagName("lesson"))
                .filter(el -> room.equals(el.getElementsByTagName("room").item(0).getTextContent()))
                .collect(Collectors.toList());

        if (found.isEmpty()) {
            System.out.println("Уроки в данной аудитории не найдены.");
        } else {
            System.out.println("Найденные уроки:");
            found.forEach(Main::printLessonInfo);
        }
    }

    private static void deleteLessonByName(Document doc, Scanner scanner) {
        System.out.print("Введите название предмета для удаления: ");
        String name = scanner.nextLine();
        NodeList list = doc.getElementsByTagName("lesson");
        boolean removed = false;

        for (int i = 0; i < list.getLength(); i++) {
            Element lesson = (Element) list.item(i);
            String lessonName = lesson.getElementsByTagName("name").item(0).getTextContent();
            if (lessonName.equalsIgnoreCase(name)) {
                doc.getDocumentElement().removeChild(lesson);
                removed = true;
                System.out.println("Урок успешно удалён.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Урок с таким названием не найден.");
        }
    }

    private static void printLessonInfo(Element lesson) {
        String name = lesson.getElementsByTagName("name").item(0).getTextContent();
        String teacher = lesson.getElementsByTagName("teacher").item(0).getTextContent();
        String room = lesson.getElementsByTagName("room").item(0).getTextContent();
        String time = lesson.getElementsByTagName("time").item(0).getTextContent();
        System.out.printf("Предмет: %s, Преподаватель: %s, Аудитория: %s, Время: %s%n",
                name, teacher, room, time);
    }

    private static Stream<Element> nodeListToStream(NodeList nl) {
        return IntStream.range(0, nl.getLength())
                .mapToObj(nl::item)
                .filter(n -> n.getNodeType() == Node.ELEMENT_NODE)
                .map(n -> (Element) n);
    }
}