package practisehighconcurrent.jdkconcurrentpackage;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
    //如果为true，则会顺序执行，false，就不一定谁去获取了
    public static ReentrantLock lock = new ReentrantLock(false);
    @Override
    public void run() {
        while(true){
            try{
                lock.lock();
                System.out.println("线程：" + Thread.currentThread().getName() + "获取锁。");
            }catch (Exception ex){

            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        Thread th1 = new Thread(new FairLock(),"Thread-1");
        Thread th2 = new Thread(new FairLock(),"Thread-2");
        th1.start();
        th2.start();
    }
}
