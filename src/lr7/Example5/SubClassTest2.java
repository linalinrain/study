package lr7.Example5;

// Второй подкласс, наследующий SuperClassTest
public class SubClassTest2 extends SuperClassTest {
    protected char symbol; // Защищенное символьное поле

    // Конструктор с двумя параметрами
    public SubClassTest2(String text, char symbol) {
        super(text);
        this.symbol = symbol;
    }

    // Геттер для symbol
    public char getSymbol() {
        return symbol;
    }

    // Сеттер для symbol
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    // Метод для отображения значений
    @Override
    public void display() {
        System.out.println("sub2" + "\n" +
                "Название класса: " + this.getClass().getSimpleName() + "\n" +
                "текстовое поле: " + getText() + "\n" +
                "символьное поле: " + symbol);
    }
}