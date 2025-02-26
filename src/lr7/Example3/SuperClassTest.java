package lr7.Example3;

// Первый суперкласс
public class SuperClassTest {
    public int number; // Открытое целочисленное поле

    // Конструктор с одним параметром
    public SuperClassTest(int number) {
        this.number = number;
    }

    // Метод для присваивания значения полю
    public void setValues(int number) {
        this.number = number;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "Название класса: " + this.getClass().getSimpleName() + ", число: " + number;
    }
}