package practisehighconcurrent.jdkconcurrentpackage;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {

        while(i< 100000){
//            lock.lock();
            try{

                i++;
//                System.out.println("Threadid=" + Thread.currentThread().getId() + ",value=" + i);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            finally {
//                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new ReentrantLockTest());
        Thread t2 = new Thread(new ReentrantLockTest());
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        Thread.sleep(5000);
        System.out.println(i);
    }
}
