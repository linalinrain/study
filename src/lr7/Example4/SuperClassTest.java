package lr7.Example4;

// Первый класс с открытым символьным полем
public class SuperClassTest {
    public char symbol; // Открытое символьное поле

    // Конструктор с параметром
    public SuperClassTest(char symbol) {
        this.symbol = symbol;
    }

    // Конструктор копирования
    public SuperClassTest(SuperClassTest clone) {
        this.symbol = clone.symbol;
    }
}