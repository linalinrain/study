package lr7.Example3;

// Третий подкласс, наследующий SubClassTest
public class SubSubClassTest extends SubClassTest {
    public String text; // Открытое текстовое поле

    // Конструктор с тремя параметрами
    public SubSubClassTest(int number, char symbol, String text) {
        super(number, symbol);
        this.text = text;
    }

    // Перегруженный метод для присваивания значений полям
    public void setValues(int number, char symbol, String text) {
        super.setValues(number, symbol);
        this.text = text;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Название класса: " + this.getClass().getSimpleName() + ", число: " + number + ", символ: " + symbol + ", текст: " + text;
    }
}