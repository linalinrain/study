package lr7.Example3;

// Второй подкласс, наследующий SuperClassTest
public class SubClassTest extends SuperClassTest {
    public char symbol; // Открытое символьное поле

    // Конструктор с двумя параметрами
    public SubClassTest(int number, char symbol) {
        super(number);
        this.symbol = symbol;
    }

    // Перегруженный метод для присваивания значений полям
    public void setValues(int number, char symbol) {
        super.setValues(number);
        this.symbol = symbol;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Название класса: " + this.getClass().getSimpleName() + ", число: " + number + ", символ: " + symbol;
    }
}