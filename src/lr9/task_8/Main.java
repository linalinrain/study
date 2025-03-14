package lr9.task_8;

public class Main {
    public static void main(String[] args) {
        // Создаём объект односвязного списка
        SinglyLinkedList list = new SinglyLinkedList();
        int[] values = {1, 2, 3, 4, 5};

        System.out.println("a) С использованием цикла:");

        // Тест: ввод с головы createHead();
        System.out.println("\nВвод с головы createHead();");
        list.createHead(values);
        System.out.println("После createHead(): " + list);

        // Тест: ввод с хвоста createTail();
        System.out.println("\nВвод с хвоста createTail();");
        list.createTail(values);
        System.out.println("После createTail(): " + list);

        // Тест: добавление элемента в начало списка addFirst(10);
        System.out.println("\nДобавление элемента в начало списка addFirst(10);");
        list.addFirst(10);
        System.out.println("После добавления элемента в начало списка addFirst(10): " + list);

        // Тест: добавление элемента в конец списка addLast(20);
        System.out.println("\nДобавление элемента в конец списка addLast(20);");
        list.addLast(20);
        System.out.println("После добавления элемента в конец списка addLast(20): " + list);

        // Тест: вставка элемента в список с указанным номером insert(3, 99);
        System.out.println("\nВставка элемента в список с указанным номером insert(3, 99);");
        list.insert(3, 99);
        System.out.println("После вставки элемента в список insert(3, 99): " + list);

        // Тест: удаление элемента с головы списка removeFirst();
        System.out.println("\nУдаление элемента с головы списка removeFirst();");
        list.removeFirst();
        System.out.println("После удаления элемента с головы списка removeFirst(): " + list);

        // Тест: удаление последнего элемента списка removeLast();
        System.out.println("\nУдаление последнего элемента списка removeLast();");
        list.removeLast();
        System.out.println("После удаления последнего элемента списка removeLast(): " + list);

        // Тест: удаление из списка элемента с указанным номером remove(2);
        System.out.println("\nУдаление из списка элемента с указанным номером remove(2);");
        list.remove(2);
        System.out.println("После удаления элемента с указанным номером remove(2): " + list);

        System.out.println("\nb) С использованием рекурсии:");

        // Тест: рекурсивный ввод с головы createHeadRec();
        System.out.println("\nРекурсивный ввод с головы createHeadRec();");
        list.createHeadRec(values);
        System.out.println("После рекурсивного ввода с головы createHeadRec(): " + list.toStringRec());

        // Тест: рекурсивный ввод с хвоста createTailRec();
        System.out.println("\nРекурсивный ввод с хвоста createTailRec();");
        list.createTailRec(values);
        System.out.println("После рекурсивного ввода с хвоста createTailRec(): " + list.toStringRec());
    }

    // Класс односвязного списка с внутренним классом Node
    public static class SinglyLinkedList {
        // Приватный статический класс для представления узла списка
        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        private Node head;

        // a) Ввод с головы createHead()
        // Итеративно создаёт список, добавляя каждый новый элемент в начало (результат – обратный порядок ввода)
        public void createHead(int[] values) {
            head = null;
            for (int value : values) {
                Node newNode = new Node(value);
                newNode.next = head;
                head = newNode;
            }
        }

        // b) Ввод с хвоста createTail()
        // Итеративно создаёт список, добавляя элементы в конец, сохраняя порядок ввода
        public void createTail(int[] values) {
            head = null;
            Node tail = null;
            for (int value : values) {
                Node newNode = new Node(value);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
        }

        // c) Вывод (возвращается строка, сформированная из элементов списка) toString()
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node current = head;
            while (current != null) {
                sb.append(current.data).append(" ");
                current = current.next;
            }
            return sb.toString().trim();
        }

        // d) Добавление элемента в начало списка addFirst()
        public void addFirst(int value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }

        // e) Добавление элемента в конец списка addLast()
        public void addLast(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        // f) Вставка элемента в список с указанным номером insert()
        public void insert(int index, int value) {
            if (index < 0) return;
            if (index == 0) {
                addFirst(value);
                return;
            }
            Node current = head;
            int currentIndex = 0;
            while (current != null && currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }
            if (current == null) return;
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        }

        // g) Удаление элемента с головы списка removeFirst()
        public void removeFirst() {
            if (head != null) {
                head = head.next;
            }
        }

        // h) Удаление последнего элемента списка removeLast()
        public void removeLast() {
            if (head == null) return;
            if (head.next == null) {
                head = null;
                return;
            }
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }

        // i) Удаление из списка элемента с указанным номером remove()
        public void remove(int index) {
            if (index < 0 || head == null) return;
            if (index == 0) {
                removeFirst();
                return;
            }
            Node current = head;
            int currentIndex = 0;
            while (current != null && current.next != null && currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }
            if (current == null || current.next == null) return;
            current.next = current.next.next;
        }

        // j) Рекурсивный ввод с головы createHeadRec()
        // Рекурсивно создаёт список с добавлением элементов "с головы".
        public void createHeadRec(int[] values) {
            head = createHeadRecHelper(values, values.length - 1);
        }

        private Node createHeadRecHelper(int[] values, int index) {
            if (index < 0) return null;
            Node newNode = new Node(values[index]);
            newNode.next = createHeadRecHelper(values, index - 1);
            return newNode;
        }

        // k) Рекурсивный ввод с хвоста createTailRec()
        // Рекурсивно создаёт список, добавляя элементы в том же порядке, что и в массиве
        public void createTailRec(int[] values) {
            head = createTailRecHelper(values, 0);
        }

        private Node createTailRecHelper(int[] values, int index) {
            if (index >= values.length) return null;
            Node newNode = new Node(values[index]);
            newNode.next = createTailRecHelper(values, index + 1);
            return newNode;
        }

        // l) Рекурсивный вывод (возвращается строка, сформированная из элементов списка) toStringRec()
        // Рекурсивно формирует строку, содержащую все элементы списка
        public String toStringRec() {
            return toStringRecHelper(head).trim();
        }

        private String toStringRecHelper(Node node) {
            if (node == null) return "";
            return node.data + " " + toStringRecHelper(node.next);
        }
    }
}