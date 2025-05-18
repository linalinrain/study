package lr12;

public class Example6 {
    private static final Object lock = new Object();
    private static final int[] numbers = {
            873, 124, 965, 388, 1023, 507, 648, 231, 904, 762,
            310, 845, 129, 700, 563, 888, 432, 678, 1001, 320
    };
    private static int result = 0;
    private static int currentIndex = 0;

    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        for (int i = 0; i < cores; i++) {
            threads[i] = new Thread(() -> {
                int localResult = 0;
                int sizeBlock = 2;
                while (true) {
                    int startIndex, endIndex;
                    synchronized (lock) {
                        startIndex = currentIndex;
                        endIndex = Math.min(currentIndex + sizeBlock, numbers.length);
                        currentIndex = endIndex;
                        if (startIndex >= numbers.length) {
                            break;
                        }
                    }
                    for (int g = startIndex; g < endIndex; g++) {
                        localResult += numbers[g];
                    }
                }
                synchronized (lock) {
                    result += localResult;
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Сумма элементов в массиве: " + result);
    }
}