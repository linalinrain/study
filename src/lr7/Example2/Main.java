package lr7.Example2;

// Главный класс для демонстрации работы
public class Main {
    public static void main(String[] args) {
        // Создание экземпляра суперкласса
        SuperClassTest superClassObj = new SuperClassTest("Пример строки");
        System.out.println("Длина строки: " + superClassObj.getTextLength());

        // Создание экземпляра подкласса
        SubClassTest subClassObj = new SubClassTest(42, "Новая строка");

        // Изменение значений полей
        subClassObj.setValues("Обновленная строка", 100);
    }
}