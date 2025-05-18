package lr12;

public class Example4 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                System.out.println("Current Thread Name: " + Thread.currentThread().getName()
                        + " Current Thread ID: " + Thread.currentThread().getId());
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}