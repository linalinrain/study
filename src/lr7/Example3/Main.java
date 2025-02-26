package lr7.Example3;

// Главный класс для демонстрации работы
public class Main {
    public static void main(String[] args) {
        // Создание экземпляра первого суперкласса
        SuperClassTest superClassObj = new SuperClassTest(10);
        System.out.println(superClassObj);

        // Создание экземпляра второго подкласса
        SubClassTest subClassObj = new SubClassTest(20, 'A');
        System.out.println(subClassObj);

        // Создание экземпляра третьего подкласса
        SubSubClassTest subSubClassObj = new SubSubClassTest(30, 'B', "Текст");
        System.out.println(subSubClassObj);
    }
}