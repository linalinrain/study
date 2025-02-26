package lr7.Example4;

// Второй класс, наследующий SuperClassTest
public class SubClassTest extends SuperClassTest {
    public String text; // Открытое текстовое поле

    // Конструктор с двумя параметрами
    public SubClassTest(char symbol, String text) {
        super(symbol);
        this.text = text;
    }

    // Конструктор копирования
    public SubClassTest(SubClassTest clone) {
        super(clone);
        this.text = clone.text;
    }
}