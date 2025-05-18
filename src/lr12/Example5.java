package lr12;

public class Example5 {
    private static final int[] numbers = {
            873, 124, 965, 388, 1023, 507, 648, 231, 904, 762,
            310, 845, 129, 700, 563, 888, 432, 678, 1001, 320
    };

    private static int globalMax = Integer.MIN_VALUE;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        int processorCount = Runtime.getRuntime().availableProcessors();
        int chunkSize = (int) Math.ceil(numbers.length / (double) processorCount);

        Thread[] threads = new Thread[processorCount];

        for (int i = 0; i < processorCount; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, numbers.length);

            threads[i] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (numbers[j] > localMax) {
                        localMax = numbers[j];
                    }
                }

                synchronized (lock) {
                    if (localMax > globalMax) {
                        globalMax = localMax;
                    }
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Максимальный элемент в массиве: " + globalMax);
    }
}
