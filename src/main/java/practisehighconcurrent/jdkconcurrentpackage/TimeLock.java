package practisehighconcurrent.jdkconcurrentpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {
    //这里必须是static，否则就不会有临界区。
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try{
            if(lock.tryLock(1, TimeUnit.SECONDS)){
                TimeUnit.SECONDS.sleep(6);
            }else{
                System.out.println("线程：" + Thread.currentThread().getId() + "获取线程失败。");
            }

        }catch (Exception ex){

        }finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args){
        Thread th1 = new Thread(new TimeLock());
        Thread th2 = new Thread(new TimeLock());
        th1.start();
        th2.start();
    }
}
