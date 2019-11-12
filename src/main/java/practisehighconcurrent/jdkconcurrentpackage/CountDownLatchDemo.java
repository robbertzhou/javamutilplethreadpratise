package practisehighconcurrent.jdkconcurrentpackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();
    @Override
    public void run() {
        try{
            TimeUnit.SECONDS.sleep(1);
            System.out.println("partion is checked.");
            end.countDown();
        }catch (InterruptedException ex){

        }
    }

    public static void main(String[] args) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start date is :" + sdf.format(new Date()));
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i =0 ;i<10;i++){
            es.submit(demo);
        }
        end.await();
        es.shutdown();
        System.out.println("start date is :" + sdf.format(new Date()));
    }
}
