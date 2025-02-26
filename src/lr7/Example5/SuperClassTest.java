package lr7.Example5;

// Суперкласс с приватным текстовым полем
public class SuperClassTest {
    private String text; // Приватное текстовое поле

    // Конструктор с текстовым параметром
    public SuperClassTest(String text) {
        this.text = text;
    }

    // Геттер для text
    public String getText() {
        return text;
    }

    // Сеттер для text
    public void setText(String text) {
        this.text = text;
    }

    // Метод для отображения названия класса и значения поля
    public void display() {
        System.out.println("super" + "\n" +
                "Название класса: " + this.getClass().getSimpleName() + "\n" +
                "текстовое поле: " + text);
    }
}