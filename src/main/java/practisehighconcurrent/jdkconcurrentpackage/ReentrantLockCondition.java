package practisehighconcurrent.jdkconcurrentpackage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    @Override
    public void run() {
        try{
            lock.lock();
            condition.await();
            System.out.println("线程:" + Thread.currentThread().getName() + " is going on.");
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        ReentrantLockCondition rlc = new ReentrantLockCondition();
        Thread t1 = new Thread(rlc);
        t1.start();
        Thread.sleep(500);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
