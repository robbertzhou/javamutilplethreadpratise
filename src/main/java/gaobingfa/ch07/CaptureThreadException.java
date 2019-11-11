package gaobingfa.ch07;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class CaptureThreadException {
    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler((t,e) ->{
            out.println(t.getName() + " occur exception.");
        });

        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(2);

            }catch (Exception ex){

            }
            int i =0;
            int k = 44 /i;
        }).start();
    }
}
