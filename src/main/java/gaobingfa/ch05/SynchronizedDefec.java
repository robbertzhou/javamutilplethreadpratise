package gaobingfa.ch05;

import java.util.concurrent.TimeUnit;

public class SynchronizedDefec {
    public synchronized void syncMethod(){
        try{
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        SynchronizedDefec sd = new SynchronizedDefec();
        Thread t1 = new Thread(sd::syncMethod);
        t1.start();
        Thread.sleep(2);
        Thread t2 = new Thread(sd::syncMethod);
        t2.start();
        t2.interrupt();
        System.out.println("ended...");
    }
}
