package lr10.task_3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "src/lr10/task_3/example03.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            JSONObject jsonObject = loadOrCreateJSON();
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
                        addNewLesson(jsonObject, scanner);
                        break;
                    case 2:
                        searchByTeacher(jsonObject, scanner);
                        break;
                    case 3:
                        searchByRoom(jsonObject, scanner);
                        break;
                    case 4:
                        deleteLessonByName(jsonObject, scanner);
                        break;
                    case 5:
                        saveJSON(jsonObject);
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

    @SuppressWarnings("unchecked")
    private static JSONObject loadOrCreateJSON() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("lessons", new JSONArray());
            return jsonObject;
        }
    }

    private static void saveJSON(JSONObject jsonObject) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(jsonObject.toJSONString());
            System.out.println("JSON-файл успешно обновлен!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void addNewLesson(JSONObject jsonObject, Scanner scanner) {
        System.out.print("Введите название предмета: ");
        String name = scanner.nextLine();
        System.out.print("Введите имя преподавателя: ");
        String teacher = scanner.nextLine();
        System.out.print("Введите номер аудитории: ");
        String room = scanner.nextLine();
        System.out.print("Введите время занятия: ");
        String time = scanner.nextLine();

        JSONArray lessons = (JSONArray) jsonObject.get("lessons");
        JSONObject lesson = new JSONObject();
        lesson.put("name", name);
        lesson.put("teacher", teacher);
        lesson.put("room", room);
        lesson.put("time", time);
        lessons.add(lesson);

        System.out.println("Урок успешно добавлен!");
    }

    private static void searchByTeacher(JSONObject jsonObject, Scanner scanner) {
        System.out.print("Введите имя преподавателя для поиска: ");
        String teacher = scanner.nextLine();
        JSONArray lessons = (JSONArray) jsonObject.get("lessons");
        boolean found = false;
        for (Object obj : lessons) {
            JSONObject lesson = (JSONObject) obj;
            if (teacher.equalsIgnoreCase((String) lesson.get("teacher"))) {
                printLesson(lesson);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Уроки данного преподавателя не найдены.");
        }
    }

    private static void searchByRoom(JSONObject jsonObject, Scanner scanner) {
        System.out.print("Введите номер аудитории для поиска: ");
        String room = scanner.nextLine();
        JSONArray lessons = (JSONArray) jsonObject.get("lessons");
        boolean found = false;
        for (Object obj : lessons) {
            JSONObject lesson = (JSONObject) obj;
            if (room.equalsIgnoreCase((String) lesson.get("room"))) {
                printLesson(lesson);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Уроки в данной аудитории не найдены.");
        }
    }

    private static void deleteLessonByName(JSONObject jsonObject, Scanner scanner) {
        System.out.print("Введите название предмета для удаления: ");
        String name = scanner.nextLine();
        JSONArray lessons = (JSONArray) jsonObject.get("lessons");
        Iterator<?> iterator = lessons.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            JSONObject lesson = (JSONObject) iterator.next();
            if (name.equalsIgnoreCase((String) lesson.get("name"))) {
                iterator.remove();
                System.out.println("Урок успешно удалён.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Урок с таким названием не найден.");
        }
    }

    private static void printLesson(JSONObject lesson) {
        System.out.println("\nТекущий элемент: lesson");
        System.out.println("Название предмета: " + lesson.get("name"));
        System.out.println("Преподаватель: " + lesson.get("teacher"));
        System.out.println("Аудитория: " + lesson.get("room"));
        System.out.println("Время: " + lesson.get("time"));
    }
}