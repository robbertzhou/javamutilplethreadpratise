package gaobingfa.ch07;

import java.util.concurrent.TimeUnit;

public class ThreadHook {
    public static void main(String[] args){
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try {
                System.out.println("Thread first is running.");
                TimeUnit.SECONDS.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread first is shutdown.");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try {
                System.out.println("Thread two is running.");
                TimeUnit.SECONDS.sleep(30);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread two is shutdown.");
        }));
        System.out.println("Main system is stopping.");
    }
}
