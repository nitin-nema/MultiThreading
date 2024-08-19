class CalculationTask1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Calculating: " + i);
        }
    }
}

class DownloadTask1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Downloading: " + i);
        }
    }
}

public class BenefitsDemo {
    public static void main(String[] args) {
        CalculationTask1 calcTask = new CalculationTask1();
        DownloadTask1 downloadTask = new DownloadTask1();

        calcTask.start();
        downloadTask.start();
    }
}
