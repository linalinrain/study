package lr7.Example1;

// Суперкласс с одним текстовым полем
public class SuperClassTest {
    private String str1; // Основное текстовое поле

    // Конструктор с параметром, инициализирует поле str1
    SuperClassTest(String strEx) {
        this.str1 = strEx;
    }

    // Пустой конструктор
    SuperClassTest() {
    }

    // Переопределение метода toString() для вывода информации о классе и полях
    @Override
    public String toString() {
        String superClassNameAndFieldValue;
        superClassNameAndFieldValue = "super" + "\n" +
                "Class name: " + this.getClass().getSimpleName() + "\n" +
                "str 1 = " + this.getStr1();
        return superClassNameAndFieldValue;
    }

    // Геттер и сеттер для str1
    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }
}
