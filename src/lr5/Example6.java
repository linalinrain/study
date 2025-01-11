package lr5;

public class Example6 {
    // Напишите программу с классом, в котором есть два закрытых целочисленных поля (max и min).
    // Значение поля max не может быть меньше значения поля min.
    // Значения полям присваиваются с помощью открытого метода, который может вызываться
    // с одним или двумя целочисленными аргументами.
    // Самое большое из значений присваивается полю max, а самое маленькое — полю min.
    // Также предусмотрен конструктор, работающий по тому же принципу, и метод для отображения значений.
    public static class ClassExample6 {
        // Закрытые целочисленные поля
        private int max;
        private int min;

        // Конструктор без аргументов
        public ClassExample6() {
        }

        // Конструктор с одним аргументом
        public ClassExample6(int number) {
            setNumbers(number, number);
        }

        // Конструктор с двумя аргументами
        public ClassExample6(int num1, int num2) {
            setNumbers(num1, num2);
        }

        // Метод для присвоения значений полям
        public void setNumbers(int num1, int num2) {
            this.max = Math.max(num1, num2);
            this.min = Math.min(num1, num2);
        }

        // Метод для присвоения одного значения обоим полям
        public void setNumbers(int number) {
            setNumbers(number, number);
        }

        // Метод для отображения значений полей
        public void printValues() {
            System.out.println("Поле min = " + min + ", Поле max = " + max);
        }
    }

    public static void main(String[] args) {
        ClassExample6 obj1 = new ClassExample6();
        // Поле min = 0, Поле max = 0
        obj1.printValues();

        obj1.setNumbers(10);
        // Поле min = 10, Поле max = 10
        obj1.printValues();

        obj1.setNumbers(5, 20);
        // Поле min = 5, Поле max = 20
        obj1.printValues();

        obj1.setNumbers(15, 15);
        // Поле min = 15, Поле max = 15
        obj1.printValues();

        ClassExample6 obj2 = new ClassExample6(30, 15);
        // Поле min = 15, Поле max = 30
        obj2.printValues();

        ClassExample6 obj3 = new ClassExample6(50);
        // Поле min = 50, Поле max = 50
        obj3.printValues();
    }
}
