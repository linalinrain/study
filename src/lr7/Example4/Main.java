package lr7.Example4;

// Главный класс для демонстрации работы
public class Main {
    public static void main(String[] args) {
        // Создание экземпляра первого класса
        SuperClassTest superClassObj = new SuperClassTest('A');
        System.out.println("Символьное поле: " + superClassObj.symbol);

        // Создание экземпляра второго класса
        SubClassTest subClassObj = new SubClassTest('B', "Текст");
        System.out.println("Символьное поле: " + subClassObj.symbol + ", Текстовое поле: " + subClassObj.text);

        // Создание экземпляра третьего класса
        SubSubClassTest subSubClassObj = new SubSubClassTest('C', "Другой текст", 42);
        System.out.println("Символьное поле: " + subSubClassObj.symbol + ", Текстовое поле: " + subSubClassObj.text + ", Числовое поле: " + subSubClassObj.number);

        // Создание копий объектов
        SuperClassTest copySuperClass = new SuperClassTest(superClassObj);
        SubClassTest copySubClass = new SubClassTest(subClassObj);
        SubSubClassTest copySubSubClass = new SubSubClassTest(subSubClassObj);

        // Вывод значений копий
        System.out.println("Копия - Символьное поле: " + copySuperClass.symbol);
        System.out.println("Копия - Символьное поле: " + copySubClass.symbol + ", Текстовое поле: " + copySubClass.text);
        System.out.println("Копия - Символьное поле: " + copySubSubClass.symbol + ", Текстовое поле: " + copySubSubClass.text + ", Числовое поле: " + copySubSubClass.number);
    }
}