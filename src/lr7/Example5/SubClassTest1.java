package lr7.Example5;

// Первый подкласс, наследующий SuperClassTest
public class SubClassTest1 extends SuperClassTest {
    protected int number; // Защищенное целочисленное поле

    // Конструктор с двумя параметрами
    public SubClassTest1(String text, int number) {
        super(text);
        this.number = number;
    }

    // Геттер для number
    public int getNumber() {
        return number;
    }

    // Сеттер для number
    public void setNumber(int number) {
        this.number = number;
    }

    // Метод для отображения значений
    @Override
    public void display() {
        System.out.println("sub1" + "\n" +
                "Название класса: " + this.getClass().getSimpleName() + "\n" +
                "текстовое поле: " + getText() + "\n" +
                "числовое поле: " + number);
    }
}