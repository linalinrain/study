package lr5;

public class Example4 {
    // Напишите программу с классом, у которого есть символьное и целочисленное поле.
    // В классе должны быть описаны версии конструктора с двумя аргументами (целое число и символ),
    // а также с одним аргументом типа double.
    // В последнем случае действительная часть аргумента определяет код символа (значение символьного поля),
    // а дробная часть (с учетом десятых и сотых) определяет значение целочисленного поля.
    // Например, если аргументом передается число 65.1267,
    // то значением символьного поля будет символ ‘A’ с кодом 65,
    // а целочисленное поле получит значение 12.
    public static class ClassExample4 {
        // Символьное поле
        public char character;

        // Целочисленное поле
        public int number;

        // Конструктор с двумя аргументами (целое число и символ)
        public ClassExample4(int number, char character) {
            this.number = number;
            this.character = character;
        }

        // Конструктор с одним аргументом типа double
        public ClassExample4(double value) {
            this.character = (char) ((int) value);  // Целая часть для символа
            this.number = (int) ((value * 100) % 100);  // Дробная часть для целого числа
        }
    }

    public static void main(String[] args) {
        ClassExample4 obj1 = new ClassExample4(65.1267);
        System.out.println("obj1: character = " + obj1.character + ", number = " + obj1.number);

        ClassExample4 obj2 = new ClassExample4(25, 'B');
        System.out.println("obj1: character = " + obj2.character + ", number = " + obj2.number);
    }
}
