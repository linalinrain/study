package lr7.Example1;

// Подкласс, наследующий SuperClassTest
public class SubClassTest extends SuperClassTest {
    private String str2; // Дополнительное текстовое поле
    private String str3; // Второе дополнительное текстовое поле

    // Конструктор с одним параметром, передает его в суперкласс
    SubClassTest(String strEx) {
        super(strEx);
    }

    // Конструктор с двумя параметрами, инициализирует собственные поля
    SubClassTest(String strEx2, String strEx3) {
        this.str2 = strEx2;
        this.str3 = strEx3;
    }

    // Переопределение метода toString() для вывода информации о классе и полях
    @Override
    public String toString() {
        String ClassNameAndFieldValue;
        ClassNameAndFieldValue = "sub" + "\n" +
                "Class name: " + this.getClass().getSimpleName() + "\n" +
                "str 1 = " + this.getStr1() + "\n" +
                "str 2 = " + this.str2 + "\n" +
                "str 3 = " + this.str3;
        return ClassNameAndFieldValue;
    }

    // Геттер и сеттер для str3
    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    // Геттер и сеттер для str2
    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }
}