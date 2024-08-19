class MyTask extends Thread {
    private final String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(500); // Sleep for 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        MyTask thread1 = new MyTask("Task 1");
        MyTask thread2 = new MyTask("Task 2");
        MyTask thread3 = new MyTask("Task 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
