package lr7.Example2;

// Суперкласс с приватным текстовым полем
public class SuperClassTest {
    private String text; // Приватное текстовое поле

    // Конструктор с текстовым параметром
    public SuperClassTest(String text) {
        this.text = text;
    }

    // Метод для присваивания значения полю
    public void setText(String text) {
        this.text = text;
    }

    // Метод для получения длины строки
    public int getTextLength() {
        return text.length();
    }
}