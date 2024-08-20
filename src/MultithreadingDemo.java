class MyThread extends Thread {
//    public MyThread(String name){
//        super(name);
//    }
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.setName("Kartik"); // Starting thread 1
        thread2.setName("Vinoth"); // Starting thread 2

        thread1.start(); // Starting thread 1
        thread2.start(); // Starting thread 2
    }
}

