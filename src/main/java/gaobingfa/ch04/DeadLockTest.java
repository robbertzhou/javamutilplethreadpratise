package gaobingfa.ch04;

public class DeadLockTest {
    private final static Object MUTEX_WRITER = new Object();
    private final static Object MUTEX_READER = new Object();

    public void read(){
        synchronized (MUTEX_READER){
            System.out.println("current name is " + Thread.currentThread().getName() + " get read lock.");
            synchronized (MUTEX_WRITER){
                System.out.println("current name is " + Thread.currentThread().getName() + " get write lock.");
            }
            System.out.println("current name is " + Thread.currentThread().getName() + " release write lock.");
        }
        System.out.println("current name is " + Thread.currentThread().getName() + " release read lock.");
    }

    public void write(){
        synchronized (MUTEX_WRITER){
            System.out.println("current name is " + Thread.currentThread().getName() + " get write lock.");
            synchronized (MUTEX_READER){
                System.out.println("current name is " + Thread.currentThread().getName() + " get read lock.");
            }
            System.out.println("current name is " + Thread.currentThread().getName() + " release read lock.");
        }
        System.out.println("current name is " + Thread.currentThread().getName() + " release write lock.");
    }

    public static void main(String[] args){
        DeadLockTest reader = new DeadLockTest();
        DeadLockTest writer = new DeadLockTest();
        new Thread(()->{
            while (true){
                reader.read();
            }
        },"thread-reader").start();

        new Thread(()->{
            while (true){
                writer.write();
            }
        },"thread-writer").start();
    }
}
