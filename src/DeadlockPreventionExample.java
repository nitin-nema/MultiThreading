import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource1{
    private final Lock lock = new ReentrantLock();
    public boolean tryLock(){
        return lock.tryLock();
    }

    public void unlock(){
        lock.unlock();
    }

    void method1(Resource1 resource){
        //Try to accquire the lock on current resource
        if(this.tryLock()){
            System.out.println(Thread.currentThread().getName() + ": Locked resources1");

            try{
                //try to accquire the lock on second resource
                if(resource.tryLock()){
                    try{
                        System.out.println(Thread.currentThread().getName() + ": Locked the resources 2");

                    }finally{
                        resource.unlock();
                    }
                }else{
                    System.out.println(Thread.currentThread().getName() + " Could not lock resouce 2");
                }
            } finally {
                this.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName() + ":Could not lock the resouce 1");
        }
    }

}
public class DeadlockPreventionExample {
    public static void main(String[] args){
        final Resource1 resource1 = new Resource1();
        final Resource1 resource2 = new Resource1();

        Thread t1 = new Thread(() -> resource1.method1(resource2));
        Thread t2 = new Thread(() -> resource2.method1(resource1));

        t1.start();
        t2.start();
    }
}
