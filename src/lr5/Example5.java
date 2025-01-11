package lr5;

public class Example5 {
    // Напишите программу с классом, у которого есть закрытое целочисленное поле.
    // Значение полю присваивается с помощью открытого метода.
    // Методу аргументом может передаваться целое число, а также метод может вызываться без аргументов.
    // Если метод вызывается без аргументов, то поле получает нулевое значение.
    // Если метод вызывается с целочисленным аргументом, то это значение присваивается полю.
    // Однако если переданное аргументом методу значение превышает 100, то значением полю присваивается число 100.
    // Предусмотрите в классе конструктор, который работает по тому же принципу, что и метод для присваивания значения полю.
    // Также в классе должен быть метод, позволяющий проверить значение поля.
    public static class ClassExample5 {
        // Закрытое целочисленное поле
        private int number;

        // Конструктор без аргументов
        public ClassExample5() {
            this.number = 0;
        }

        // Конструктор с аргументом
        public ClassExample5(int number) {
            setNumber(number);
        }

        // Метод для присвоения значения полю без аргументов (обнуляет поле)
        public void setNumber() {
            this.number = 0;
        }

        // Метод для присвоения значения полю с аргументом
        public void setNumber(int number) {
            this.number = Math.min(number, 100);
        }

        // Метод для проверки значения поля
        public void printNumber() {
            System.out.println("Текущее значение поля number = " + number);
        }
    }

    public static void main(String[] args) {
        ClassExample5 obj1 = new ClassExample5();
        obj1.printNumber();

        obj1.setNumber();
        obj1.printNumber();

        obj1.setNumber(100);
        obj1.printNumber();

        obj1.setNumber(101);
        obj1.printNumber();

        ClassExample5 obj2 = new ClassExample5(150);
        obj2.printNumber();

        obj2.setNumber(99);
        obj2.printNumber();

        obj2.setNumber(100);
        obj2.printNumber();

        obj2.setNumber(101);
        obj2.printNumber();
    }
}
