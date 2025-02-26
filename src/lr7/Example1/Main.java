package lr7.Example1;

// Главный класс для демонстрации работы
public class Main {
    public static void main(String[] args) {
        // Создание экземпляра суперкласса с передачей строки в конструктор
        SuperClassTest superClassObject =
                new SuperClassTest("Передал в конструктор суперкласса");
        String className = superClassObject.toString();
        System.out.println(className);

        // Создание экземпляра подкласса с одним параметром
        SubClassTest subClassObject1 =
                new SubClassTest("передал в конструктор подкласса");
        String subClassName = subClassObject1.toString();
        System.out.println(subClassName);

        // Создание экземпляра подкласса с двумя параметрами
        SubClassTest subClassObject2 =
                new SubClassTest("Передал в конструктор подкласса", "где два параметра");
        String subClassName2 = subClassObject2.toString();
        System.out.println(subClassName2);
    }
}