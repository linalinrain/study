package lr6;

public class Example1 {
    // Напишите программу с классом, в котором есть два поля: символьное и текстовое.
    // В классе должен быть перегруженный метод для присваивания значений полям.
    // Если метод вызывается с символьным аргументом, то соответствующее значение присваивается символьному полю.
    // Если метод вызывается с текстовым аргументом, то он определяет значение текстового поля.
    // Методу аргументом также может передаваться символьный массив.
    // Если массив состоит из одного элемента, то он определяет значение символьного поля.
    // В противном случае (если в массиве больше одного элемента), из символов массива формируется текстовая строка
    // и присваивается значением текстовому полю.
    public static class ClassExample1 {
        // Символьное поле
        private char charField;
        // Текстовое поле
        private String textField;

        // Метод для присваивания значения символьному полю
        public void setValue(char value) {
            this.charField = value;
        }

        // Метод для присваивания значения текстовому полю
        public void setValue(String value) {
            this.textField = value;
        }

        // Метод для обработки символьного массива
        public void setValue(char[] value) {
            if (value.length == 1) {
                this.charField = value[0];
            } else {
                this.textField = new String(value);
            }
        }

        // Метод для отображения текущих значений полей
        public void displayValues() {
            System.out.println("charField = " + charField);
            System.out.println("textField = " + textField);
        }
    }

    public static void main(String[] args) {
        ClassExample1 obj = new ClassExample1();
        // Присваиваем значение символьному полю
        obj.setValue('A');
        obj.displayValues();
        // Присваиваем значение текстовому полю
        obj.setValue("Митягин");
        obj.displayValues();
        // Присваиваем значение символьному полю через массив
        obj.setValue(new char[]{'B'});
        obj.displayValues();
        // Присваиваем значение текстовому полю через массив
        obj.setValue(new char[]{'В', 'л', 'а', 'д', 'и', 'м', 'и', 'р'});
        obj.displayValues();
    }
}
