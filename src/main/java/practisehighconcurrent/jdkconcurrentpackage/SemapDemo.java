package practisehighconcurrent.jdkconcurrentpackage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemapDemo implements Runnable{
    final Semaphore sema = new Semaphore(2);
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        try{
            sema.acquire();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("The " + Thread.currentThread().getId() + ":done." + sdf.format(new Date()));
            sema.release();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        SemapDemo sd = new SemapDemo();
        for (int i =0;i<6;i++){
            //要做成效果，必须为同一个SemaDemo对象
//            Thread thread = new Thread(new SemapDemo());
//            thread.start();
            Thread thread = new Thread(sd);
            thread.start();
        }
    }

    //test result:
//    The 13:done.2019-11-12 10:17:18
//    The 12:done.2019-11-12 10:17:18
//    The 14:done.2019-11-12 10:17:20
//    The 15:done.2019-11-12 10:17:20
//    The 17:done.2019-11-12 10:17:22
//    The 16:done.2019-11-12 10:17:22
}
