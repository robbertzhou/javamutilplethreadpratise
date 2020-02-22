package highconcurrence.chapter02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * create 2020-02-22
 * author zhouyu
 * desc 线程与虚拟机栈
 */
public class ThreadCounter extends Thread{
    final static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args){
        try{
            while (true){
                new ThreadCounter().start();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            System.out.println("The " + counter.getAndIncrement() + " thread be created.");
            TimeUnit.MINUTES.sleep(20);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
