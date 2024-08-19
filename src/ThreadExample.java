class FileDownloader extends Thread {
    private String fileName;

    public FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println("Downloading " + fileName);
        // Simulate file download with sleep
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(fileName + " downloaded.");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        FileDownloader thread1 = new FileDownloader("file1.txt");
        FileDownloader thread2 = new FileDownloader("file2.txt");

        thread1.start(); // Start downloading file1.txt
        thread2.start(); // Start downloading file2.txt
    }
}
