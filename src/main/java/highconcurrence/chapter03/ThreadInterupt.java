package highconcurrence.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * create 2020-02-22
 * author zhouyu
 * desc 线程的interrupt方法，中断一个线程执行
 */
public class ThreadInterupt {
    public static void main(String[] args) throws Exception{
        //①判断当前线程是否被中断
        System.out.println("Main thread is interrupted？"+ Thread.currentThread().interrupted());
        //2 interrupt
        Thread.currentThread().interrupt();
        //③判断当前线程是否已经被中断
        System.out.println("Main thread is interrupted？"+Thread.currentThread().interrupted());
        try
        {

//④当前线程执行可中断方法

            TimeUnit.SECONDS.sleep(10);

        }catch(InterruptedException e){
            System.out.println("I will be interrupted still.");
        }




//        Thread thread = new Thread(()-> {
//            try{
//                TimeUnit.SECONDS.sleep(30);
//            }catch (InterruptedException ex){
//                System.out.println("Oh,i am breaked.");
//            }
//        });
//        thread.setDaemon(true);
//        thread.start();
//
//        TimeUnit.SECONDS.sleep(1);
//        thread.interrupt();
    }
}
