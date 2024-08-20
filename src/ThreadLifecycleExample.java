class LifecycleDemo implements Runnable {
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + ": Running");
            Thread.sleep(1000); // Running to Timed Waiting
            synchronized (this) {
                wait(); // Running to Waiting
            }
            System.out.println(Thread.currentThread().getName() + ": Resumed and Running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLifecycleExample {
    public static void main(String[] args) throws InterruptedException {
        LifecycleDemo demo = new LifecycleDemo();
        Thread thread = new Thread(demo);

        System.out.println(thread.getState()); // New
        thread.start();
        System.out.println(thread.getState()); // Runnable

        Thread.sleep(500); // Allow thread to start
        System.out.println(thread.getState()); // Timed Waiting

        synchronized (demo) {
            demo.notify(); // Moving thread from Waiting to Runnable
        }

//        Thread.sleep(500);
        thread.join();
        System.out.println("State after conpletion" + thread.getState()); // Terminated (after completion)
    }
}
