package lr5;

public class Example3 {
    // Напишите программу с классом, у которого есть два целочисленных поля.
    // В классе должны быть описаны конструкторы, позволяющие создавать
    // объекты без передачи аргументов,
    // с передачей одного аргумента
    // и с передачей двух аргументов.
    public static class ClassExample3 {
        // Первое целочисленное поле
        public int firstNumber;

        // Второе целочисленное поле
        public int secondNumber;

        // Конструктор без аргументов
        public ClassExample3() {
            this.firstNumber = 0;
            this.secondNumber = 0;
        }

        // Конструктор с одним аргументом
        public ClassExample3(int number) {
            this.firstNumber = number;
            this.secondNumber = 0;
        }

        // Конструктор с двумя аргументами
        public ClassExample3(int firstNumber, int secondNumber) {
            this.firstNumber = firstNumber;
            this.secondNumber = secondNumber;
        }
    }

    public static void main(String[] args) {
        ClassExample3 obj1 = new ClassExample3();
        System.out.println("obj1: firstNumber = " + obj1.firstNumber + ", secondNumber = " + obj1.secondNumber);

        ClassExample3 obj2 = new ClassExample3(5);
        System.out.println("obj2: firstNumber = " + obj2.firstNumber + ", secondNumber = " + obj2.secondNumber);

        ClassExample3 obj3 = new ClassExample3(3, 7);
        System.out.println("obj3: firstNumber = " + obj3.firstNumber + ", secondNumber = " + obj3.secondNumber);
    }
}
