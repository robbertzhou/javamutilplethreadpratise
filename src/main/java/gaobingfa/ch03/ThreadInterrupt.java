package gaobingfa.ch03;


import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("Oh,i am be interrupted.");
                }
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(10);
        thread.interrupt();
    }
}
