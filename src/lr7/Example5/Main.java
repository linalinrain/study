package lr7.Example5;

// Главный класс для демонстрации работы
public class Main {
    public static void main(String[] args) {
        // Создание объектов каждого класса
        SuperClassTest superClassObj = new SuperClassTest("Текст суперкласса");
        SubClassTest1 subClassObj1 = new SubClassTest1("Текст подкласса 1", 100);
        SubClassTest2 subClassObj2 = new SubClassTest2("Текст подкласса 2", 'A');

        // Вызов метода display() для каждого объекта
        superClassObj.display();
        subClassObj1.display();
        subClassObj2.display();

        // Вызов метода через объектную переменную суперкласса
        SuperClassTest ref;

        ref = subClassObj1;
        ref.display();

        ref = subClassObj2;
        ref.display();
    }
}