package lr6;

public class Example2 {
    // Напишите программу с классом, в котором есть закрытое статическое
    // целочисленное поле с начальным нулевым значением.
    // В классе должен быть описан статический метод,
    // при вызове которого отображается текущее значение статического поля,
    // после чего значение поля увеличивается на единицу.
    public static class ClassExample2 {
        // Закрытое статическое целочисленное поле с начальным нулевым значением
        private static int number = 0;

        // Статический метод для отображения текущего значения и увеличения на единицу
        public static void displayNumberValueAndIncreaseByOne() {
            System.out.println("Текущее значение number = " + number);
            number = number + 1;
        }
    }

    public static void main(String[] args) {
        // Вызов статического метода несколько раз для демонстрации работы
        ClassExample2.displayNumberValueAndIncreaseByOne();
        ClassExample2.displayNumberValueAndIncreaseByOne();
        ClassExample2.displayNumberValueAndIncreaseByOne();
    }
}