class DownloadTask implements Runnable {
    private String fileName;

    public DownloadTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Downloading " + fileName);
        try {
            Thread.sleep(2000); // Simulate download time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(fileName + " downloaded.");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DownloadTask("file1.txt"));
        Thread thread2 = new Thread(new DownloadTask("file2.txt"));

        thread1.start();
        thread2.start();
    }
}
