class MyRunnable1 implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

public class StartVsRunExample {
    public static void main(String[] args) {
        MyRunnable1 runnable = new MyRunnable1();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start(); // Starts a new thread
        thread2.run(); // Runs in the main thread, not a new thread
    }
}
