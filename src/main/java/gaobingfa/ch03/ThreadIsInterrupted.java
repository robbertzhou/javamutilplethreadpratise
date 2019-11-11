package gaobingfa.ch03;

import java.util.concurrent.TimeUnit;

public class ThreadIsInterrupted {
    public static void main(String[] args) throws Exception{
        Thread th = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("oh,i am be interrupted.");
                    }
                }
            }
        };
        th.setDaemon(true);
        th.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("thread isInterrupted is " + th.isInterrupted());
        th.interrupt();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("thread isInterrupted is " + th.isInterrupted());
    }

}
