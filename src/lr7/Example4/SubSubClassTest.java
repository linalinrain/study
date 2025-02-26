package lr7.Example4;

// Третий класс, наследующий SubClassTest
public class SubSubClassTest extends SubClassTest {
    public int number; // Открытое целочисленное поле

    // Конструктор с тремя параметрами
    public SubSubClassTest(char symbol, String text, int number) {
        super(symbol, text);
        this.number = number;
    }

    // Конструктор копирования
    public SubSubClassTest(SubSubClassTest clone) {
        super(clone);
        this.number = clone.number;
    }
}