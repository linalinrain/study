package lr7.Example2;

// Подкласс, наследующий SuperClassTest
public class SubClassTest extends SuperClassTest {
    public int number; // Публичное целочисленное поле

    // Конструктор с двумя параметрами (целочисленный и текстовый)
    public SubClassTest(int number, String text) {
        super(text);
        this.number = number;
    }

    // Метод без параметров
    public void setValues() {
        super.setText("");
        this.number = 0;
    }

    // Метод с текстовым параметром
    public void setValues(String text) {
        super.setText(text);
    }

    // Метод с целочисленным параметром
    public void setValues(int number) {
        this.number = number;
    }

    // Метод с текстовым и целочисленным параметром
    public void setValues(String text, int number) {
        super.setText(text);
        this.number = number;
    }
}