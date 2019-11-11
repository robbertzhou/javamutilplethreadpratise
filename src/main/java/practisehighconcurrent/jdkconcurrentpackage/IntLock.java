package practisehighconcurrent.jdkconcurrentpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    public int i;

    public IntLock(int i){
        this.i = i;
    }

    @Override
    public void run() {
        try {
            if(this.i == 1){
                lock1.tryLock(2,TimeUnit.SECONDS);
                try{

                    TimeUnit.SECONDS.sleep(1);

                }catch (Exception ex){}
                lock2.tryLock(2,TimeUnit.SECONDS);
            }else{
                lock2.tryLock(2,TimeUnit.SECONDS);
                try{

                    TimeUnit.SECONDS.sleep(1);

                }catch (Exception ex){}
                lock1.tryLock(2,TimeUnit.SECONDS);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println("线程：" + Thread.currentThread().getId() + "==退出。");
        }

    }

    public static void main(String[] args){
        IntLock il1 = new IntLock(1);
        IntLock il2 = new IntLock(2);
        Thread th1 = new Thread(il1);
        Thread th2 = new Thread(il2);
        th1.start();
        th2.start();

    }
}
