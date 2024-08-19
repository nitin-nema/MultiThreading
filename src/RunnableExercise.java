class CalculationTask implements Runnable {
    private int number;

    public CalculationTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int result = number * number;
        System.out.println("Square of " + number + " is: " + result);
    }
}

public class RunnableExercise {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new CalculationTask(5));
        Thread thread2 = new Thread(new CalculationTask(7));
        Thread thread3 = new Thread(new CalculationTask(9));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
