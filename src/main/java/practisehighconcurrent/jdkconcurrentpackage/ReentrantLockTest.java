package practisehighconcurrent.jdkconcurrentpackage;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        while(i< 100000000){
            lock.lock();
            try{

                i++;
            }catch (Exception ex){

            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new ReentrantLockTest());
        Thread t2 = new Thread(new ReentrantLockTest());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
