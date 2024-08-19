import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintTask implements Runnable {
    private String message;

    public PrintTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Executing: " + message);
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new PrintTask("Task 1"));
        executor.submit(new PrintTask("Task 2"));
        executor.submit(new PrintTask("Task 3"));

        executor.shutdown(); // Initiates an orderly shutdown
    }
}
